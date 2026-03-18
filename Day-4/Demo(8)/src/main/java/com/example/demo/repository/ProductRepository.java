package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProductsEntity;

public interface ProductRepository extends JpaRepository<ProductsEntity, Long>{
    // select * from product where bill_id = ?
    List<ProductsEntity> findByBillId(Long billId);
}
