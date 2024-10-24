package com.example.demo.dtos.responsedto;


import java.io.Serializable;
import java.util.List;

public class ToDoDto implements Serializable {
    private long id;
    private String name;
    List<SubToDoDto> subToDos;

    public ToDoDto() {
    }

    public ToDoDto(long id, String name, List<SubToDoDto> subToDos) {
        this.id = id;
        this.name = name;
        this.subToDos = subToDos;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubToDoDto> getSubToDos() {
        return subToDos;
    }

    public void setSubToDos(List<SubToDoDto> subToDos) {
        this.subToDos = subToDos;
    }
}
