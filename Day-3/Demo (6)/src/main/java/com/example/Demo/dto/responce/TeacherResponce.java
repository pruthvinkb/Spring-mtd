package com.example.Demo.dto.responce;

public class TeacherResponce {
    private Long id;
    private String name;
    private String phone;
    private String departmentName;
    
    public TeacherResponce(Long id, String name, String phone, String departmentName) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.departmentName = departmentName;
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}