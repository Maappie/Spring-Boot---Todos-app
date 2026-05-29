package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // Business Logic: Save a new To-Do item to the database
    public Todo createTodo(Todo todo) {
        // This is where business logic rules live (e.g., checking if title is empty)
        if (todo.getTitle() == null || todo.getTitle().trim().isEmpty()) {
            throw new IllegalArgumentException("Todo title cannot be empty!");
        }
        return todoRepository.save(todo);
    }

    // Business Logic: Fetch all existing To-Do items
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
}