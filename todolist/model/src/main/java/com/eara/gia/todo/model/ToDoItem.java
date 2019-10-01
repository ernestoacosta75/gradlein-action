package com.eara.gia.todo.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class represents an action item in the
 * to-do list.
 *
 * @author Ernesto A. Rodriguez Acosta
 *
 */
@Data
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Builder
public class ToDoItem implements Comparable<ToDoItem> {

    private Long id;
    private String name;
    private boolean completed;

    public ToDoItem(Long id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    @Override
    public int compareTo(ToDoItem o) {
        return this.getId().compareTo(o.getId());
    }
}
