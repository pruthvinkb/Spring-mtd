package com.example.billing.service;

import com.example.billing.entity.BillEntity;
import com.example.billing.entity.UserEntity;
import com.example.billing.repository.BillRepository;
import com.example.billing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BillService {
    @Autowired
    private BillRepository billRepository;
    
    @Autowired
    private UserRepository userRepository;

    public BillEntity createBill(Long userId) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (user.isPresent()) {
            BillEntity bill = new BillEntity();
            bill.setUser(user.get());
            return billRepository.save(bill);
        }
        return null;
    }

    public List<BillEntity> getAllBills() {
        return billRepository.findAll();
    }

    public List<BillEntity> getBillsByUserId(Long userId) {
        return billRepository.findByUserId(userId);
    }

    public Optional<BillEntity> getBillById(Long id) {
        return billRepository.findById(id);
    }
}