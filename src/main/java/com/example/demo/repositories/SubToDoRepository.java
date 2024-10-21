package com.example.demo.repositories;

import com.example.demo.entities.SubToDo;
import com.example.demo.entities.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubToDoRepository extends CrudRepository<SubToDo,Long> {

    @NonNull
    @Override
    List<SubToDo> findAll();
}
