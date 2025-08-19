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

    // to-do 작성
    @Transactional
    public TaskDto create(TaskDto reqTask) {
        // 엔티티 생성
        Task task = Task.createTask(reqTask);
        Task saved = taskRepository.save(task);

        return TaskDto.createDto(saved);
    }

    // to-do 수정
    @Transactional
    public TaskDto patch(Long id, TaskDto reqTask) {
        Task result = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TO-DO 수정 실패 : 없는 ID 입니다."));

        // TO-DO 수정
        result.patch(reqTask);

        // DB 갱신
        Task updated = taskRepository.save(result);
        return TaskDto.createDto(updated);
    }

    @Transactional
    public TaskDto delete(Long id) {
        Task target = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TO-DO 삭제 실패 : 없는 ID 입니다."));

        taskRepository.delete(target);
        return TaskDto.createDto(target);
    }

    @Transactional
    public List<TaskDto> deleteChecked(List<TaskDto> dtos) {

        // ID List 추출
        List<Long> id = dtos.stream()
                        .map(TaskDto::getId)
                        .toList();

        List<Task> target = taskRepository.findAllById(id);
        taskRepository.deleteAll(target);

        return target.stream()
                .map(TaskDto::createDto).toList();
    }
}
