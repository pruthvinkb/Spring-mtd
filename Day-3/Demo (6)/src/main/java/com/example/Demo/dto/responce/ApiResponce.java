package com.example.Demo.dto.responce;

public class ApiResponce<T> {
    private String Status;
    private T data;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ApiResponce(String status, T data) {
        Status = status;
        this.data = data;
    }
    
}
