package com.example.demo.services;

import com.example.demo.dtos.requestdtos.AddSubToDoDto;
import com.example.demo.dtos.requestdtos.AddToDoDto;
import com.example.demo.dtos.requestdtos.EditToDoDto;
import com.example.demo.dtos.responsedto.ResponseDto;
import com.example.demo.dtos.responsedto.ResponseEditToDoDto;
import com.example.demo.dtos.responsedto.SubToDoDto;
import com.example.demo.dtos.responsedto.ToDoDto;
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


    public ResponseDto<ToDoDto> addTodo(String name){
        try {
            ToDo toDo = new ToDo(name);
            toDo = this.toDoRepository.save(toDo);
            ToDoDto toDoDto = new ToDoDto(toDo.getId(), toDo.getName(), new ArrayList<>());
            return new ResponseDto<>(
                    true,
                    "Added successfully",
                    toDoDto
            );
        }
        catch(Exception e){
            e.printStackTrace();
            return new ResponseDto<>(
                    false,
                    "Error while creating todo",
                    null
            );
        }
    }

    public ResponseDto<SubToDoDto> addSubToDo(AddSubToDoDto addSubToDoDto) {
        long taskid = addSubToDoDto.getTaskId();
        String name = addSubToDoDto.getName();
        Optional<ToDo> toDo = this.toDoRepository.findById(taskid);
        if(toDo.isEmpty()) {
            return new ResponseDto<>(false, "No Task found with the given id");
        }
        try {
            SubToDo subToDo = new SubToDo(name, toDo.get());
            subToDo = this.subToDoRepository.save(subToDo);
            SubToDoDto subToDoDto = new SubToDoDto(
                    subToDo.getId(),
                    subToDo.getTask().getId(),
                    subToDo.getName()
                    );
            return new ResponseDto<>(
                    true,
                    " Sub task added successfully",
                    subToDoDto
            );
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(
                    false,
                    " failed to add Sub Task",
                    null
            );
        }
    }

    public ResponseDto<Boolean> deleteTodo(long id) {
        try {
            this.toDoRepository.deleteById(id);
            return new ResponseDto<>(true, " deleted successfully", true);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, " deleted successfully", false);
        }
    }

    public ResponseDto<Boolean> deleteSubToDo(long id) {
        try {
            this.subToDoRepository.deleteById(id);
            return new ResponseDto<>(true, " deleted successfully", true);
        }
        catch(Exception e) {
            e.printStackTrace();
            return new ResponseDto<>(false, " deleted successfully", false);
        }
    }

    public ResponseDto<List<ToDoDto>> getToDos() {
        try{
            List<ToDo> toDos = this.toDoRepository.findAll();
            ResponseDto<List<ToDoDto>> response = new ResponseDto<>();
            List<ToDoDto> toDoDtos = new ArrayList<>();
            for (ToDo toDo:toDos) {
                List<SubToDoDto> subToDoDtos = new ArrayList<>(toDo.getSubtasks().size());

                for ( SubToDo subToDo:toDo.getSubtasks()) {
                    subToDoDtos.add(new SubToDoDto(
                            subToDo.getId(),
                            subToDo.getTask().getId(),
                            subToDo.getName()
                    ));
                }
                toDoDtos.add(new ToDoDto(toDo.getId(), toDo.getName(), subToDoDtos));
            }
            response.setSuccess(true);
            response.setData(toDoDtos);
            return response;
        }
        catch(Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResponseDto<ResponseEditToDoDto> editToDo(EditToDoDto editToDoDto) {
        Optional<ToDo> toDo = this.toDoRepository.findById(editToDoDto.getId());
        if(toDo.isEmpty()) {
            return new ResponseDto<>(false, "no record found");
        }
        ToDo todo = toDo.get();
        if(editToDoDto.getName()!=null) {
            todo.setName(editToDoDto.getName());
        }
        todo = this.toDoRepository.save(todo);
        return new ResponseDto<>(
                true,
                "edited successfully",
                new ResponseEditToDoDto(todo.getId(), todo.getName()));
    }

    public ResponseDto<ResponseEditToDoDto> editSubToDo(EditToDoDto editToDoDto) {
        Optional<SubToDo> subToDo = this.subToDoRepository.findById(editToDoDto.getId());
        if(subToDo.isEmpty()) {
            return new ResponseDto<>(false, "no record found");
        }
        SubToDo subtodo = subToDo.get();
        if(editToDoDto.getName()!=null) {
            subtodo.setName(editToDoDto.getName());
        }
        subtodo = this.subToDoRepository.save(subtodo);
        return new ResponseDto<>(
                true,
                "edited successfully",
                new ResponseEditToDoDto(subtodo.getId(), subtodo.getName()));
    }
}
