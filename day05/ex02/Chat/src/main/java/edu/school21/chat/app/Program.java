package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("abridger");
        dataSource.setPassword("");

        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);

        User creator = new User(4, "dwulfe", "888", new ArrayList(), new ArrayList());
        User author = creator;
        Chatroom room = new Chatroom(5, "room", creator, new ArrayList());
        Message message = new Message(null, author, room, "Hello! My name is Sasha", LocalDateTime.now());
        try{
            repository.save(message);
            System.out.println(message.getId());
        } catch (NotSavedSubEntityException e){
            e.printStackTrace();
        }
    }
}
