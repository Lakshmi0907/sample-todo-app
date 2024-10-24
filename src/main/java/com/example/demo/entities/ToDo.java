package com.example.demo.entities;


import com.example.demo.dtos.responsedto.ToDoDto;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    // One Task can have many Subtasks
    @Nullable
    @OneToMany(mappedBy = "toDo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubToDo> subtasks;

    public ToDo() {

    }
    public ToDo(String name) {
        this.name = name;
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

    public List<SubToDo> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubToDo> subtasks) {
        this.subtasks = subtasks;
    }
}
