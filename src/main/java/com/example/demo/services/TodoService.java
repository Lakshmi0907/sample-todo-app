package com.example.demo.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service()
public class TodoService {
    private List<String> toDos;

    public TodoService() {
        toDos = new ArrayList<>();
        toDos.add("Task 1");
        toDos.add("Task 2");
        toDos.add("Task 3");
        toDos.add("Task 4");
        toDos.add("Task 5");
        toDos.add("Task 6");
    }

    public void addTodo(String name) {
        this.toDos.add(name);
    }

    public void deleteTodo(String name) {
        this.toDos.remove(name);
    }

    public List<String> getToDos() {
        return this.toDos;
    }
}
