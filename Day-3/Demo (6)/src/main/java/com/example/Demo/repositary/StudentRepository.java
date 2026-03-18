package com.example.Demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Demo.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    
}
