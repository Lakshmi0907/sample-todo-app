package com.example.demo.controllers;

import com.example.demo.dtos.AddSubToDoDto;
import com.example.demo.dtos.AddToDoDto;
import com.example.demo.dtos.DeleteToDoDTO;
import com.example.demo.entities.SubToDo;
import com.example.demo.entities.ToDo;
import com.example.demo.services.TodoService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api")
public class ToDoRestController {
    @Autowired
    TodoService todoService;

    @GetMapping("/todos/view")
    public List<ToDo> toDo() {
        return todoService.getToDos();
    }

//    @GetMapping("/csrf")
//    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
//        Object csrfAttribute = httpServletRequest.getAttribute("_csrf");
//        return (CsrfToken) csrfAttribute;
//
//    }
    @PostMapping("/todo/add")
    public ToDo addToDo(@RequestBody AddToDoDto addToDoDto) {
        return todoService.addTodo(addToDoDto.getName());
    }

    @GetMapping("/todo/delete")
    public Boolean deleteToDo(@RequestParam("id") long id) {
        todoService.deleteTodo(id);
        return true;
    }

    @PostMapping("/todo/add-subtodo")
    public String addSubToDo(@RequestBody AddSubToDoDto addSubToDoDto) {
        if(todoService.addSubToDo(addSubToDoDto.getTaskId(), addSubToDoDto.getName())!=null) {
            return "record added successfully";
        }
        else
            return "Some error occured";
    }
}
