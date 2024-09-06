package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoRestController {

    private List<String> toDos;

    public ToDoRestController() {
        toDos = new ArrayList<>();
        toDos.add("Task 1");
        toDos.add("Task 2");
        toDos.add("Task 3");
        toDos.add("Task 4");
        toDos.add("Task 5");
        toDos.add("Task 6");
    }

    @GetMapping("/todos")
    public List<String> toDo() {
        return this.toDos;
    }
}
