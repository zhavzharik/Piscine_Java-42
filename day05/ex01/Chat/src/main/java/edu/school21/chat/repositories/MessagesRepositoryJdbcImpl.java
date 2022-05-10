package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository{

    private final DataSource dataSource;
    private Connection connection;
    private final String SQL_SELECT_BY_ID = "SELECT * FROM chat.messages WHERE msg_id = ?";

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        try {
            this.connection = dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException();
        }
    }

    @Override
    public Optional<Message> findById(Long id) throws NoSuchElementException {

        try{
            Optional<Message> messageOptional;
            PreparedStatement statement = connection.prepareStatement(SQL_SELECT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
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
}
