package com.example.toDoList.service;

import com.example.toDoList.entity.Task;
import com.example.toDoList.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public ArrayList<Task> index() {
        return taskRepository.findAll();
    }
}
