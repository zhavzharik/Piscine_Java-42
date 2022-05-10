package edu.school21.sockets.repositories;

import java.util.List;

public interface CrudRepository <T> {
    T findById(Integer id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(Integer id);
}
