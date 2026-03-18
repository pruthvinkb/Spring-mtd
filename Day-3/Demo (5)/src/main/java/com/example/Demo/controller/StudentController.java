package com.example.Demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    
    @PostMapping("/process")
    public ApiResponce<StudentResponce> saveStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponce studentResponce = studentService.saveStudent(studentRequest);
        return new ApiResponce<>("success", studentResponce);
    }

    @PostMapping("/{id}/register")
    public ApiResponce<StudentResponce> assignRegister(
        @PathVariable long id,
        @RequestBody String registrationNumber
    ) {
        StudentResponce studentResponce = studentService.assignRegistration(id, registrationNumber);
        return new ApiResponce<>("success", studentResponce);
    }
}
