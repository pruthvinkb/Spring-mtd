package com.example.Demo.Service;

import org.springframework.stereotype.Service;
import com.example.Demo.dto.request.TeacherRequest;
import com.example.Demo.dto.responce.TeacherResponce;
import com.example.Demo.entity.TeacherEntity;
import com.example.Demo.entity.DepartmentEntity;
import com.example.Demo.repositary.TeacherRepository;
import com.example.Demo.repositary.DepartmentRepository;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final DepartmentRepository departmentRepository;

    public TeacherService(TeacherRepository teacherRepository, DepartmentRepository departmentRepository) {
        this.teacherRepository = teacherRepository;
        this.departmentRepository = departmentRepository;
    }
    
    public TeacherResponce saveTeacher(TeacherRequest teacherRequest) {
        DepartmentEntity department = departmentRepository.findById(teacherRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        
        TeacherEntity teacher = new TeacherEntity();
        teacher.setName(teacherRequest.getName());
        teacher.setPhone(teacherRequest.getPhone());
        teacher.setDepartment(department);
        
        TeacherEntity savedTeacher = teacherRepository.save(teacher);

        return new TeacherResponce(
            savedTeacher.getId(),
            savedTeacher.getName(),
            savedTeacher.getPhone(),
            savedTeacher.getDepartment().getDepartmentName()
        );
    }
}