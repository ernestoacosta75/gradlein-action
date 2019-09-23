package com.eara.gia.todo.repositories.impl;

import com.eara.gia.todo.model.ToDoItem;
import com.eara.gia.todo.repositories.TodoRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * This class represents a thread/safe implementation of
 * the <b>TodoRepository</b> interface, which stores to-do items
 * in an instance of a <b>ConcurrentHashMap</b>.
 *
 * @author Ernesto A. Rodriguez Acosta
 */
public class TodoRepositoryInMemoryImpl implements TodoRepository {

    // THread-safe provider for identifier sequence number
    private AtomicLong currentId = new AtomicLong();

    // Efficient in-memory data structure for storing to-do items
    private ConcurrentHashMap<Long, ToDoItem> toDos = new ConcurrentHashMap<>();

    @Override
    public List<ToDoItem> findAll() {
        List<ToDoItem> todoItems = new ArrayList<ToDoItem>(toDos.values());

        // Sorting to-do items by identifier
        Collections.sort(todoItems);

        return todoItems;
    }

    @Override
    public ToDoItem findById(Long id) {
        return toDos.get(id);
    }

    @Override
    public Long insert(ToDoItem todoItem) {
        Long id = currentId.incrementAndGet();
        todoItem.setId(id);

        // Only puts to-do item into Map if doesn't exist yet
        toDos.putIfAbsent(id, todoItem);

        return id;
    }

    @Override
    public void update(ToDoItem todoItem) {
        // Replaces to-do item if existent in Map
        toDos.replace(todoItem.getId(), todoItem);
    }

    @Override
    public void delete(ToDoItem todoItem) {
        // Removes to-do item if existent in Map
        toDos.remove(todoItem.getId());
    }
}
