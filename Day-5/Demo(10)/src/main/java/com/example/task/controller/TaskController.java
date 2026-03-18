package com.example.task.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.example.task.dto.TaskRequest;
import com.example.task.dto.TaskResponse;
import com.example.task.response.ApiResponse;
import com.example.task.service.TaskService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    // BULK INSERT USING LIST
    @PostMapping
    public ApiResponse<List<TaskResponse>> createTasks(
            @Valid @RequestBody List<TaskRequest> requests) {

        List<TaskResponse> response = service.createTasks(requests);

        return new ApiResponse<>("success", response);
    }

    // GET ALL TASKS (with optional pagination)
    @GetMapping
    public ApiResponse<?> getAllTasks(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size,
            @RequestParam(required = false) String sort) {

        if (page != null || size != null) {
            // Paginated request
            Pageable pageable = org.springframework.data.domain.PageRequest.of(
                page != null ? page : 0,
                size != null ? size : 10
            );
            Page<TaskResponse> response = service.getAllTasksPaginated(pageable);
            return new ApiResponse<>("success", response);
        } else {
            // Regular request
            List<TaskResponse> response = service.getAllTasks();
            return new ApiResponse<>("success", response);
        }
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteTask(@PathVariable Long id){

        service.deleteTask(id);

        return new ApiResponse<>("success", "Task Deleted");
    }
}