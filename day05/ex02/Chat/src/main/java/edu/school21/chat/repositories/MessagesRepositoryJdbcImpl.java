package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;
    private final String SQL_SELECT_BY_ID = "SELECT * FROM chat.messages WHERE msg_id = ?";
    private final String SQL_ADD_MSG = "insert into chat.messages (msg_author, msg_room, msg_text, msg_date) VALUES (?, ?, ?, ?)";

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long id) throws NoSuchElementException {

        try{
            Connection connection = dataSource.getConnection();
            Optional<Message> messageOptional;
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            User my_user = new User(1, "abridger", "123", null, null);
            Message msg = new Message(resultSet.getInt(1), my_user, new Chatroom(1, "chat1", my_user, null),
                    resultSet.getString(4),
                    resultSet.getObject(5, LocalDateTime.class));
            messageOptional = Optional.of(msg);
            connection.close();
            return messageOptional;
        } catch (SQLException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public boolean save(Message message) throws NotSavedSubEntityException {

        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_ADD_MSG, Statement.RETURN_GENERATED_KEYS)) {
            statement.setInt(1, message.getAuthor().getId());
            statement.setInt(2, message.getRoom().getId());
            statement.setString(3, message.getText());
            statement.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
            statement.executeUpdate();
            ResultSet key = statement.getGeneratedKeys();
            key.next();
            message.setId(key.getInt(1));
        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
        return true;
    }
}

