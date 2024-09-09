package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.dtos.AddToDoDto;
import com.example.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class ToDoController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public String listToDos(Model model) {
        model.addAttribute("todos", todoService.getToDos());
        return "todos";
    }

    @PostMapping("/todo")
    public String addANewToDo(@ModelAttribute AddToDoDto toDoDto, Model model) {
        todoService.addTodo(toDoDto.getName());
        model.addAttribute("todos", todoService.getToDos());
        return "todos";
    }


    
}
