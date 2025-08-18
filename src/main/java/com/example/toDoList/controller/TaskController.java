package com.example.toDoList.controller;

import com.example.toDoList.dto.TaskDto;
import com.example.toDoList.entity.Task;
import com.example.toDoList.repository.TaskRepository;
import com.example.toDoList.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskRepository taskRepository;

    @GetMapping("api/task")
    public List<Task> index() {

        return taskRepository.findAll();
    }

    // 할 일 작성
    @PostMapping("/api/task")
    public ResponseEntity<TaskDto> create(@RequestBody TaskDto reqTask) {
        // 서비스 위임
        TaskDto taskDto = taskService.create(reqTask);

        return ResponseEntity.status(HttpStatus.OK).body(taskDto);
    }
}
