package com.eara.gia.todo.repository.impl;

import com.eara.gia.todo.model.ToDoItem;
import com.eara.gia.todo.repository.TodoRepository;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TodoRepositoryInMemoryImplTest {

    private TodoRepository todoImMemoryRepositoryImpl;
/**
    @Before
    public void setUp() throws Exception {
        todoImMemoryRepositoryImpl = new TodoRepositoryInMemoryImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findById() {
    }

    @Test
    public void insert() {
        ToDoItem newToDoItem = new ToDoItem();

        newToDoItem.setName("Write unit tests");
        Long newId = todoImMemoryRepositoryImpl.insert(newToDoItem);

        assertNotNull(newId );

        ToDoItem persistedTodoItem = todoImMemoryRepositoryImpl.findById(newId);

        assertNotNull(persistedTodoItem);
        assertEquals(newToDoItem, persistedTodoItem);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }*/

    /**
     * Using TestNG
     */

    @BeforeClass
    public void setUp() throws Exception {
        todoImMemoryRepositoryImpl = new TodoRepositoryInMemoryImpl();
    }

    @AfterClass
    public void tearDown() throws Exception {
    }

    @org.testng.annotations.Test
    public void findAll() {
    }

    @org.testng.annotations.Test
    public void findById() {
    }

    @org.testng.annotations.Test
    public void insert() {
        ToDoItem newToDoItem = new ToDoItem();

        newToDoItem.setName("Write unit tests");
        Long newId = todoImMemoryRepositoryImpl.insert(newToDoItem);

        assertNotNull(newId );

        ToDoItem persistedTodoItem = todoImMemoryRepositoryImpl.findById(newId);

        assertNotNull(persistedTodoItem);
        assertEquals(newToDoItem, persistedTodoItem);
    }

    @org.testng.annotations.Test
    public void update() {
    }

    @org.testng.annotations.Test
    public void delete() {
    }
}