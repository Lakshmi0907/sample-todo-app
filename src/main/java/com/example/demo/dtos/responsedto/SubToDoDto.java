package com.example.demo.dtos.responsedto;

public class SubToDoDto {
    private long id;
    private long taskId;
    private String name;

    public SubToDoDto() {
    }

    public SubToDoDto(long id, long taskId, String name) {
        this.id = id;
        this.taskId = taskId;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
