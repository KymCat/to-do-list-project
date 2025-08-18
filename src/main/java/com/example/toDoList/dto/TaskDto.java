package com.example.toDoList.dto;

import com.example.toDoList.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private String todayTask;

    public static TaskDto createDto(Task saved) {
        return new TaskDto(
                saved.getId(),
                saved.getTodayTask()
        );
    }
}
