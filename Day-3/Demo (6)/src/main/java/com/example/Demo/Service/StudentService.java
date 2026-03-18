package com.example.Demo.Service;

import org.springframework.stereotype.Service;
import com.example.Demo.dto.request.StudentRequest;
import com.example.Demo.dto.responce.StudentResponce;
import com.example.Demo.entity.StudentEntity;
import com.example.Demo.entity.DepartmentEntity;
import com.example.Demo.repositary.StudentRepository;
import com.example.Demo.repositary.DepartmentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;

    public StudentService(StudentRepository studentRepository, DepartmentRepository departmentRepository) {
        this.studentRepository = studentRepository;
        this.departmentRepository = departmentRepository;
    }
    
    public StudentResponce saveStudent(StudentRequest studentRequest) {
        DepartmentEntity department = departmentRepository.findById(studentRequest.getDepartmentId())
                .orElseThrow(() -> new RuntimeException("Department not found"));
        
        StudentEntity student = new StudentEntity();
        student.setName(studentRequest.getName());
        student.setPhone(studentRequest.getPhone());
        student.setAddress(studentRequest.getAddress());
        student.setDob(studentRequest.getDob());
        student.setDepartment(department);
        
        StudentEntity savedStudent = studentRepository.save(student);

        return new StudentResponce(
            savedStudent.getId(),
            savedStudent.getName(),
            savedStudent.getPhone(),
            savedStudent.getAddress(),
            savedStudent.getDob(),
            savedStudent.getDepartment().getDepartmentName()
        );
    }
}