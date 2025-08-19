package com.example.toDoList.repository;

import com.example.toDoList.dto.TaskDto;
import com.example.toDoList.entity.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    @Override
    List<Task> findAllById(Iterable<Long> longs);
}
