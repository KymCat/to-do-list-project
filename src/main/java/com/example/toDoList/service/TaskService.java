package com.example.toDoList.service;

import com.example.toDoList.dto.TaskDto;
import com.example.toDoList.entity.Task;
import com.example.toDoList.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public List<Task> index() {
        return taskRepository.findAll();
    }

    @Transactional
    public TaskDto create(TaskDto reqTask) {
        // 엔티티 생성
        Task task = Task.createTask(reqTask);
        Task saved = taskRepository.save(task);

        return TaskDto.createDto(saved);
    }


}
