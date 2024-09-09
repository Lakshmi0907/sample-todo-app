package com.example.demo.controllers;

import com.example.demo.dtos.AddToDoDto;
import com.example.demo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ToDoRestController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public List<String> toDo() {
        return todoService.getToDos();
    }

    @PostMapping("/todo")
    public Boolean addToDo(@RequestBody AddToDoDto addToDoDto) {
        todoService.addTodo(addToDoDto.getName());
        return true;
    }
}
