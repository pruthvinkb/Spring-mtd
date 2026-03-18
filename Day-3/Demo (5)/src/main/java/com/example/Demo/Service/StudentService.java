package com.example.Demo.Service;

import org.springframework.stereotype.Service;

import com.example.Demo.dto.request.StudentRequest;
import com.example.Demo.dto.responce.StudentResponce;
import com.example.Demo.entity.StudentEntity;
import com.example.Demo.entity.RegisterNumberEntity;
import com.example.Demo.repositary.RegisterNumberRepository;
import com.example.Demo.repositary.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final RegisterNumberRepository registerNumberRepository;

    public StudentService(StudentRepository studentRepository, RegisterNumberRepository registerNumberRepository) {
        this.studentRepository = studentRepository;
        this.registerNumberRepository = registerNumberRepository;
    }
    
    public StudentResponce saveStudent(StudentRequest studentRequest) {
         
        StudentEntity student = new StudentEntity();
        student.setName(studentRequest.getName());
        StudentEntity savedStudent = studentRepository.save(student);

        return new StudentResponce(savedStudent.getId(), 
        savedStudent.getName(), null );
    }

    public StudentResponce assignRegistration(Long StudentId, String registrationNumber) {
        StudentEntity student = studentRepository.findById(StudentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        RegisterNumberEntity registerNumber = new RegisterNumberEntity();
        registerNumber.setRegNumber(registrationNumber);
        RegisterNumberEntity savedRegisterNumber = registerNumberRepository.save(registerNumber);
        student.setRegosterNumber(savedRegisterNumber);
        studentRepository.save(student);
        
        return new StudentResponce(student.getId(), student.getName(), savedRegisterNumber.getRegNumber());
    }
}