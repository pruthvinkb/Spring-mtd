package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponse;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentResponse processStudent(StudentRequest request) {
        int total = request.getMarks().stream().mapToInt(Integer::intValue).sum();
        
        int subjects = request.getMarks().size();
        double percentage = (double) total / subjects;
        String result = percentage >= 75 ? "Pass" : "Fail";

        Student student = new Student();
        student.setName(request.getName());
        student.setRollNumber(request.getRollNumber());
        student.setTotal(total);
        student.setPercentage(percentage);
        student.setResult(result);

        studentRepository.save(student);

        return new StudentResponse(
            request.getName(),
            request.getRollNumber(),
            total,
            percentage,
            result
    );
}
    public List<StudentResponse> getResults() {
  return studentRepository.findAll()
  .stream()
        .map(student -> new StudentResponse(
                student.getName(),
                student.getRollNumber(),
                student.getTotal(),
                student.getPercentage(),
                student.getResult()
        )).toList();

    }

    public List<StudentResponse> processStudents(List<StudentRequest> requests) {
        return requests.stream()
                .map(this::processStudent)
                .collect(Collectors.toList());
    }
}
