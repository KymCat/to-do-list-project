package com.example.toDoList.repository;

import com.example.toDoList.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    ArrayList<Task> findAll();
}
