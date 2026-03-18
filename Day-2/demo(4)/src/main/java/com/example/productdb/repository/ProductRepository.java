package com.example.productdb.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.productdb.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

    
}
