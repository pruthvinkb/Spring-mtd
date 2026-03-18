package com.example.task.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.task.dto.TaskRequest;
import com.example.task.dto.TaskResponse;
import com.example.task.entity.TaskEntity;
import com.example.task.repository.TaskRepository;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskResponse> createTasks(List<TaskRequest> requests) {

        List<TaskEntity> tasks = requests.stream()
                .map(req -> TaskEntity.builder()
                        .title(req.getTitle())
                        .description(req.getDescription())
                        .status(req.getStatus())
                        .build())
                .collect(Collectors.toList());

        List<TaskEntity> savedTasks = repository.saveAll(tasks);

        return savedTasks.stream()
                .map(task -> TaskResponse.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .status(task.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    public List<TaskResponse> getAllTasks() {

        return repository.findAll().stream()
                .map(task -> TaskResponse.builder()
                        .id(task.getId())
                        .title(task.getTitle())
                        .description(task.getDescription())
                        .status(task.getStatus())
                        .build())
                .collect(Collectors.toList());
    }

    public Page<TaskResponse> getAllTasksPaginated(Pageable pageable) {

        Page<TaskEntity> taskPage = repository.findAll(pageable);
        
        return taskPage.map(task -> TaskResponse.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .status(task.getStatus())
                .build());
    }

    public void deleteTask(Long id){
        repository.deleteById(id);
    }
}