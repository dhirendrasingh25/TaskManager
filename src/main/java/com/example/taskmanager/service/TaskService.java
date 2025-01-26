package com.example.taskmanager.service;


import com.example.taskmanager.dto.TaskDTO;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

   final TaskRepository taskRepository;
    final ModelMapper modelMapper;

    public TaskService(TaskRepository taskRepository ,ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    public List<TaskDTO> getAllTasks(){
        List<Task> tasks = taskRepository.findAll();
        // Logging for debugging purposes
        System.out.println("Billaha Shot");

        // Convert Task entities to TaskDTOs
        List<TaskDTO> taskDTOs = tasks.stream()
                .map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());

        // Print each TaskDTO
        taskDTOs.forEach(taskDTO -> System.out.println(taskDTO));

        // Return the converted TaskDTOs
        return taskDTOs;
    };

    public void createTask(TaskDTO taskDTO){};

    public TaskDTO getTaskById(Long id){
        return null;
    };

    public void updateTask(TaskDTO taskDTO){};


}
