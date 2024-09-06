package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {
    private List<String> toDos;

    public ToDoController() {
        toDos = new ArrayList<>();
        toDos.add("Task 1");
        toDos.add("Task 2");
        toDos.add("Task 3");
        toDos.add("Task 4");
        toDos.add("Task 5");
        toDos.add("Task 6");
    }

    @GetMapping("/todos")
    public String listToDos(Model model) {
        model.addAttribute("todos", this.toDos);
        return "todos";
    }
}
