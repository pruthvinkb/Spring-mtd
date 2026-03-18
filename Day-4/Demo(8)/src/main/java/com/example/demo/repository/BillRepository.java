package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.BillsEntity;

public interface BillRepository extends JpaRepository<BillsEntity, Long>{
    // select * from bills where user_id = ?
    List<BillsEntity> findByUserId(Long userId);
}
