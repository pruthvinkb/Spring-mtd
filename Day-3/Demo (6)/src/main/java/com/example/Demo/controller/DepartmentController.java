package com.example.Demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.Demo.Service.DepartmentService;
import com.example.Demo.dto.request.DepartmentRequest;
import com.example.Demo.dto.responce.ApiResponce;
import com.example.Demo.dto.responce.DepartmentResponce;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    @PostMapping
    public ApiResponce<DepartmentResponce> saveDepartment(@RequestBody DepartmentRequest departmentRequest) {
        DepartmentResponce departmentResponce = departmentService.saveDepartment(departmentRequest);
        return new ApiResponce<>("success", departmentResponce);
    }
}