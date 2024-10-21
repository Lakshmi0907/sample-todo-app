package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class SubToDo {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String name;

        // Many Subtasks can belong to one Task
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "task_id", nullable = false)
        private ToDo toDo;

        // Constructors, Getters, and Setters
        public SubToDo() {}

        public SubToDo(String name, boolean completed) {
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ToDo getTask() {
            return toDo;
        }

        public void setTask(ToDo toDo) {
            this.toDo = toDo;
        }
    }
