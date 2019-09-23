package com.eara.gia.todo.repositories;

import com.eara.gia.todo.model.ToDoItem;

import java.util.List;

/**
 * This class represents the storage data engine.
 *
 * To be implemented.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public interface TodoRepository {
    List<ToDoItem> findAll();
    ToDoItem findById(Long id);
    Long insert(ToDoItem todoItem);
    void update(ToDoItem todoItem);
    void delete(ToDoItem todoItem);
}
