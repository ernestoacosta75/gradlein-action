package com.eara.gia.todo.web;

import com.eara.gia.todo.model.ToDoItem;
import com.eara.gia.todo.repositories.TodoRepository;
import com.eara.gia.todo.repositories.impl.TodoRepositoryInMemoryImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToDoServlet extends HttpServlet {

    private TodoRepository todoRepository = new TodoRepositoryInMemoryImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String servletPath = req.getServletPath();
        String view = processRequest(servletPath, req);
    }

    private String processRequest(String servletPath, HttpServletRequest request) {
        if(servletPath.equals("/all")) {
            List<ToDoItem> toDoItems = todoRepository.findAll();
            request.setAttribute("toDoItems", toDoItems);
            return "/jsp/todo-list.jsp";
        }
        else if(servletPath.equals("/delete")) {

        }

        return "/all";
    }
}
