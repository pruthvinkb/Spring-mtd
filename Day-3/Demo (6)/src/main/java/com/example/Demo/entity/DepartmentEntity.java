package com.example.Demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;
    
    private String departmentName;
    
    @OneToMany(mappedBy = "department")
    private List<StudentEntity> students;
    
    @OneToMany(mappedBy = "department")
    private List<TeacherEntity> teachers;

    public Long getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public List<StudentEntity> getStudents() {
        return students;
    }
    public void setStudents(List<StudentEntity> students) {
        this.students = students;
    }
    public List<TeacherEntity> getTeachers() {
        return teachers;
    }
    public void setTeachers(List<TeacherEntity> teachers) {
        this.teachers = teachers;
    }
}