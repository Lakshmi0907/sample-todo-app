package com.example.demo.dtos;

import com.example.demo.entities.SubToDo;

import java.io.Serializable;
import java.util.List;

public class ResponseToDoDto implements Serializable {
    private long id;
    private String name;
    List<SubToDo> subToDos;
}
