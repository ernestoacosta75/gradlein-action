package com.eara.gia.todo.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ToDoItemTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testLombokAnnotations() throws Exception {
        ToDoItem toDoItem = ToDoItem.builder().id(1L).name("some name").build();

        Assert.assertEquals(toDoItem.getName(), "some name");
    }
}