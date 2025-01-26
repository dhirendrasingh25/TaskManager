package com.example.taskmanager.controller;


import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public String getAllTasks(Model model) {
        List<TaskDTO> tasks = taskService.getAllTasks();
        System.out.println("bynty");
        tasks.forEach(System.out::println);
        model.addAttribute("tasks", tasks);

        return "tasks/taskList";
    }
}
