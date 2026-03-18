package com.example.demo.dto.response;

public class ApiResponse {
    private String status;
    private StudentResponse data;

    public ApiResponse(String status, StudentResponse data) {
        this.status = status;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentResponse getData() {
        return data;
    }

    public void setData(StudentResponse data) {
        this.data = data;
    }
}
