package com.example.toDoList.controller;

import com.example.toDoList.entity.Task;
import com.example.toDoList.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Slf4j
@Controller
@RequiredArgsConstructor
public class toDoListController {
    private final TaskService taskService;

    // 전체 To-DO-List 조회
    @GetMapping("/index")
    public String index(Model model) {
        ArrayList<Task> tasks = taskService.index();
        model.addAttribute("tasks", tasks);

        return "task/index";
    }

    @GetMapping("/tmp")
    public String tmp() {
        return "task/tmp";
    }

}
