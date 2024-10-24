package com.example.demo.dtos.requestdtos;

import java.io.Serializable;

public class AddSubToDoDto implements Serializable {

    private long taskId;
    private String name;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
