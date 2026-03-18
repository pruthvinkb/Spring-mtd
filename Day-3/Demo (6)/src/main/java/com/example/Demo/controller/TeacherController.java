package com.example.Demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.Demo.Service.TeacherService;
import com.example.Demo.dto.request.TeacherRequest;
import com.example.Demo.dto.responce.ApiResponce;
import com.example.Demo.dto.responce.TeacherResponce;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @PostMapping
    public ApiResponce<TeacherResponce> saveTeacher(@RequestBody TeacherRequest teacherRequest) {
        TeacherResponce teacherResponce = teacherService.saveTeacher(teacherRequest);
        return new ApiResponce<>("success", teacherResponce);
    }
}