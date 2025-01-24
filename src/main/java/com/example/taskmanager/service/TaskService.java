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
        return tasks.stream()
                .map((task)->modelMapper.map(task,TaskDTO.class))
                .collect(Collectors.toList());
    };

    public void createTask(TaskDTO taskDTO){};

    public TaskDTO getTaskById(Long id){
        return null;
    };

    public void updateTask(TaskDTO taskDTO){};


}
