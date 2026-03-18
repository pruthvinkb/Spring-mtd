package com.example.Demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.Demo.Service.StudentService;
import com.example.Demo.dto.request.StudentRequest;
import com.example.Demo.dto.responce.ApiResponce;
import com.example.Demo.dto.responce.StudentResponce;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping
    public ApiResponce<StudentResponce> saveStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponce studentResponce = studentService.saveStudent(studentRequest);
        return new ApiResponce<>("success", studentResponce);
    }
}
