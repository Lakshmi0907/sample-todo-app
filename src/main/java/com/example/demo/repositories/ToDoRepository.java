package com.example.demo.repositories;

import com.example.demo.entities.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    @Override
    List<ToDo> findAll();
    Long countById(Long id);

}
