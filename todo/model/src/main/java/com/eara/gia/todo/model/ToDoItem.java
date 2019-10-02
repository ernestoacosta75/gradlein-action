package com.eara.gia.todo.model;

/**
 * This class represents an action item in the
 * to-do list.
 *
 * @author Ernesto A. Rodriguez Acosta
 *
 */
public class ToDoItem implements Comparable<ToDoItem> {

    private Long id;
    private String name;
    private boolean completed;

    public ToDoItem(Long id, String name, boolean completed) {
        this.id = id;
        this.name = name;
        this.completed = completed;
    }

    public ToDoItem() {
    }

    public static ToDoItemBuilder builder() {
        return new ToDoItemBuilder();
    }

    @Override
    public int compareTo(ToDoItem o) {
        return this.getId().compareTo(o.getId());
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ToDoItem)) return false;
        final ToDoItem other = (ToDoItem) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.isCompleted() != other.isCompleted()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ToDoItem;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + (this.isCompleted() ? 79 : 97);
        return result;
    }

    public String toString() {
        return "ToDoItem(id=" + this.getId() + ", name=" + this.getName() + ", completed=" + this.isCompleted() + ")";
    }

    public static class ToDoItemBuilder {
        private Long id;
        private String name;
        private boolean completed;

        ToDoItemBuilder() {
        }

        public ToDoItem.ToDoItemBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ToDoItem.ToDoItemBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ToDoItem.ToDoItemBuilder completed(boolean completed) {
            this.completed = completed;
            return this;
        }

        public ToDoItem build() {
            return new ToDoItem(id, name, completed);
        }

        public String toString() {
            return "ToDoItem.ToDoItemBuilder(id=" + this.id + ", name=" + this.name + ", completed=" + this.completed + ")";
        }
    }
}
