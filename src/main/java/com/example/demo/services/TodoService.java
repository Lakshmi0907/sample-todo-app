package com.example.demo.services;

import com.example.demo.entities.SubToDo;
import com.example.demo.entities.ToDo;
import com.example.demo.repositories.SubToDoRepository;
import com.example.demo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service()
public class TodoService {
    @Autowired
    private ToDoRepository toDoRepository;
    @Autowired
    private SubToDoRepository subToDoRepository;


    public ToDo addTodo(String name){
        try {
            ToDo toDo = new ToDo(name);
            return this.toDoRepository.save(toDo);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public SubToDo addSubToDo(long taskid, String name) {

        Optional<ToDo> toDo = this.toDoRepository.findById(taskid);
        if(toDo.isEmpty()) {
            return null;
        }
        try {
            SubToDo subToDo = new SubToDo();
            subToDo.setName(name);
//            subToDo.setId(taskid);
            subToDo.setTask(toDo.get());
//            System.out.println(subToDo.getId());
            return this.subToDoRepository.save(subToDo);
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public void deleteTodo(Long id) {

        this.toDoRepository.deleteById(id);
    }

    public List<ToDo> getToDos() {
        try{
            return this.toDoRepository.findAll();
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
