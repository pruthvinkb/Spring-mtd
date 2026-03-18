package com.example.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.service.StudentService;
import com.example.demo.dto.response.ApiResponse;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/calculate")
    public ApiResponse getResult(@RequestBody StudentRequest request) {
        StudentResponse response = studentService.calculateResult(request);
        return new ApiResponse("Result calculated successfully", response);
    }
}
