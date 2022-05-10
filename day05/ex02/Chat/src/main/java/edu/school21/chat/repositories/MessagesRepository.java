package edu.school21.chat.repositories;

import edu.school21.chat.exceptions.NotSavedSubEntityException;
import edu.school21.chat.models.Message;

import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface MessagesRepository {
    Optional<Message> findById(Long Id) throws NoSuchElementException;
    boolean save(Message message) throws NotSavedSubEntityException;
}
