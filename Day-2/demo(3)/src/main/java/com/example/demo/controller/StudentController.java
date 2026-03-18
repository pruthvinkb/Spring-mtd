package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.ApiResponse;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/result")
    public ApiResponse<StudentResponse> getResult(@RequestBody StudentRequest request) {
        StudentResponse response = studentService.processStudent(request);
        return new ApiResponse<>("Result calculated successfully", response);
    }

    @GetMapping("/result")
    public List<StudentResponse> getStudentResults() {
        return studentService.getResults();
    }

    @PostMapping("/results")
    public ApiResponse<List<StudentResponse>> processMultipleStudents(@RequestBody List<StudentRequest> requests) {
        List<StudentResponse> responses = studentService.processStudents(requests);
        return new ApiResponse<>("Results calculated successfully", responses);
    }
}
