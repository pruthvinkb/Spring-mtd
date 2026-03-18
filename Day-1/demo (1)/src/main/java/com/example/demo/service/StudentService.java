package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.request.StudentRequest;
import com.example.demo.dto.response.StudentResponse;

@Service
public class StudentService {
    public StudentResponse calculateResult(StudentRequest request) {
        int total = request.getMarks1() + request.getMarks2() + request.getMarks3() + request.getMarks4() + request.getMarks5();
        
        double percentage = total / 5.0;
        String result = percentage >= 75 ? "Pass" : "Fail";

        return new StudentResponse(
            request.getName(), Integer.parseInt(request.getRollNumber()), 
            total, percentage, result);
    }
}
