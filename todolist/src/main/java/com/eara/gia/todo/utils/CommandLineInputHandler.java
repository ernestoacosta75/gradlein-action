package com.eara.gia.todo.utils;

import com.eara.gia.todo.model.ToDoItem;
import com.eara.gia.todo.repositories.TodoRepository;
import com.eara.gia.todo.repositories.impl.TodoRepositoryInMemoryImpl;
import lombok.Data;

import java.util.Collection;

@Data
public class CommandLineInputHandler {

    private TodoRepository toDoRepository = new TodoRepositoryInMemoryImpl();

    public void printOptions() {
        System.out.println("\n--- To Do Application ---");
        System.out.println("Please make a choice:");
        System.out.println("(a)ll items");
        System.out.println("(f)ind an specific item");
        System.out.println("(i)nsert a new item");
        System.out.println("(u)pdate an existing item");
        System.out.println("(d)elete an existing item");
        System.out.println("(e)xit");
    }

    public String readInput() {
        return System.console().readLine("> ");
    }

    public void processInput(com.eara.gia.todo.utils.CommandLineInput input) {
        if(input == null) {
            handleUnknownInput();
        }
        else {
            switch (input) {
                case FIND_ALL:
                    printAllTodoItems();
                    break;
                case FIND_BY_ID:
                    printToDoItem();
                    break;
                case INSERT:
                    insertToDoItem();
                    break;
                case UPDATE:
                    updateToDoItem();
                    break;
                case DELETE:
                    deleteToDoItem();
                    break;
                case EXIT:
                    break;
                default:
                    handleUnknownInput();
            }
        }
    }

    private Long askForItemId() {
        System.out.println("Please enter the item ID:");
        String input = readInput();

        return Long.parseLong(input);
    }

    private ToDoItem askForNewToDoAction() {
        ToDoItem todoItem = new ToDoItem();
        System.out.println("Please enter the name of the item:");

        todoItem.builder().name(readInput()).build();

        return todoItem;
    }

    private void printAllTodoItems() {
        Collection<ToDoItem> todoItems = toDoRepository.findAll();

        if(todoItems.isEmpty()) {
            System.out.println("Nothing to do. Go relax!");
        }
        else {
            for (ToDoItem todoItem : todoItems) {
                System.out.println(todoItem);
            }
        }
    }

    private void printToDoItem() {
        ToDoItem todoItem = findToDoItem();

        if(todoItem != null) {
            System.out.println(todoItem);
        }
    }

    private ToDoItem findToDoItem() {
        Long id = askForItemId();
        ToDoItem todoItem = toDoRepository.findById(id);

        if(todoItem == null) {
            System.out.println("To do item with ID " + id + " could not be found.");
        }

        return todoItem;
    }

    private void insertToDoItem() {
        ToDoItem toDoItem = askForNewToDoAction();
        Long id = toDoRepository.insert(toDoItem);
        System.out.println("Successfully inserted to do item with ID " + id + ".");
    }

    private void updateToDoItem() {
        ToDoItem toDoItem = findToDoItem();

        if (toDoItem != null) {
            System.out.println(toDoItem);
            System.out.println("Please enter the name of the item:");
            toDoItem.setName(readInput());
            System.out.println("Please enter the done status the item:");
            toDoItem.setCompleted(Boolean.parseBoolean(readInput()));
            toDoRepository.update(toDoItem);
            System.out.println("Successfully updated to do item with ID " + toDoItem.getId() + ".");
        }
    }

    private void deleteToDoItem() {
        ToDoItem toDoItem = findToDoItem();

        if (toDoItem != null) {
            toDoRepository.delete(toDoItem);
            System.out.println("Successfully deleted to do item with ID " + toDoItem.getId() + ".");
        }
    }

    private void handleUnknownInput() {
        System.out.println("Please select a valid option!");
    }

}
