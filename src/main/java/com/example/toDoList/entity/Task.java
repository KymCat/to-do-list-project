package com.example.toDoList.entity;

import com.example.toDoList.dto.TaskDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String todayTask;

    // DTO => Entity 변환
    public static Task createTask(TaskDto taskDto) {
        if (taskDto.getId() != null)
            throw new IllegalArgumentException("할 일 생성 실패 : id의 값이 없어야 합니다");
        else if (taskDto.getTodayTask() == null)
            throw new IllegalArgumentException("할 일 생성 실패 : 입력한 할 일 값이 null 입니다.");

        // 엔티티 생성
        return new Task(
            taskDto.getId(),
            taskDto.getTodayTask()
        );
    }

    // TO-DO 수정
    public void patch(TaskDto reqTask) {
        if (this.id != reqTask.getId())
            throw new IllegalArgumentException("TO-DO 수정 실패 : 잘못된 ID가 입력 되었습니다.");

        // 수정 할 TO-DO가 있다면
        if (reqTask.getTodayTask() != null)
            this.todayTask = reqTask.getTodayTask();
    }
}
