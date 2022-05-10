package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws NoSuchElementException {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("abridger");
        dataSource.setPassword("");


        MessagesRepository repository = new MessagesRepositoryJdbcImpl(dataSource);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a message ID");
        System.out.print("-> ");
        try {
            Optional<Message> result = repository.findById(scanner.nextLong());
            result.ifPresent(System.out::println);
        } catch (NoSuchElementException e) {
            System.err.println("There is no such ID in the database!");
            System.exit(-1);
        }
    }
}
