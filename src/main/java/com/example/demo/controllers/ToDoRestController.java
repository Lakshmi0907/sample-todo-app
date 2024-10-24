package com.example.demo.controllers;

import com.example.demo.dtos.requestdtos.AddSubToDoDto;
import com.example.demo.dtos.requestdtos.AddToDoDto;
import com.example.demo.dtos.requestdtos.EditToDoDto;
import com.example.demo.dtos.responsedto.ResponseDto;
import com.example.demo.dtos.responsedto.ResponseEditToDoDto;
import com.example.demo.dtos.responsedto.SubToDoDto;
import com.example.demo.dtos.responsedto.ToDoDto;
import com.example.demo.entities.ToDo;
import com.example.demo.services.TodoService;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.web.server.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class ToDoRestController {
    @Autowired
    TodoService todoService;

    @GetMapping("/")
    public ResponseDto<List<ToDoDto>> toDo() {
        return todoService.getToDos();
    }

//    @GetMapping("/csrf")
//    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest) {
//        Object csrfAttribute = httpServletRequest.getAttribute("_csrf");
//        return (CsrfToken) csrfAttribute;
//
//    }
    @PostMapping("/")
    public ResponseDto<ToDoDto> addToDo(@RequestBody AddToDoDto addToDoDto) {
        return todoService.addTodo(addToDoDto.getName());
    }

    @DeleteMapping("/")
    public ResponseDto<Boolean> deleteToDo(@RequestParam("id") long id) {
        return todoService.deleteTodo(id);
    }

    @DeleteMapping("/subtodo")
    public ResponseDto<Boolean> deleteSubToDo(@RequestParam("id") long id) {
        return todoService.deleteSubToDo(id);
    }

    @PostMapping("/subtodo")
    public ResponseDto<SubToDoDto> addSubToDo(@RequestBody AddSubToDoDto addSubToDoDto) {
            return todoService.addSubToDo(addSubToDoDto);
    }

    @PutMapping("/")
    public ResponseDto<ResponseEditToDoDto> editToDo(@RequestBody EditToDoDto editToDoDto) {
        return todoService.editToDo(editToDoDto);
    }

    @PutMapping("/subtodo")
    public ResponseDto<ResponseEditToDoDto> editSubToDo(@RequestBody EditToDoDto editToDoDto) {
        return todoService.editSubToDo(editToDoDto);
    }
}
