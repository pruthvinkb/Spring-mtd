package com.example.Demo.Service;

import org.springframework.stereotype.Service;
import com.example.Demo.dto.request.DepartmentRequest;
import com.example.Demo.dto.responce.DepartmentResponce;
import com.example.Demo.entity.DepartmentEntity;
import com.example.Demo.repositary.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    
    public DepartmentResponce saveDepartment(DepartmentRequest departmentRequest) {
        DepartmentEntity department = new DepartmentEntity();
        department.setDepartmentName(departmentRequest.getDepartmentName());
        DepartmentEntity savedDepartment = departmentRepository.save(department);
        
        return new DepartmentResponce(savedDepartment.getDepartmentId(), savedDepartment.getDepartmentName());
    }
}