package com.example.Demo.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Demo.entity.RegisterNumberEntity;

public interface RegisterNumberRepository extends JpaRepository<RegisterNumberEntity, Long> {

}