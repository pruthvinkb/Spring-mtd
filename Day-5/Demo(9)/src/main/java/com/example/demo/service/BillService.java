package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BillRequest;
import com.example.demo.dto.BillResponse;
import com.example.demo.entity.BillsEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.UserRepository;

@Service
public class BillService {
    private final BillRepository billRepository;
    private final UserRepository userRepository;
    public BillService(BillRepository billRepository, UserRepository userRepository) {
        this.billRepository = billRepository;
        this.userRepository = userRepository;
    }

    public BillResponse createBill(BillRequest request){
        // validate user is already created or not
        UserEntity userEntity = userRepository.findById(request.getUserId()).orElseThrow();

        // if already present insert the id to the current bill
        BillsEntity billsEntity = new BillsEntity();
        billsEntity.setUser(userEntity);

        BillsEntity savedBill = billRepository.save(billsEntity);

        BillResponse response = new BillResponse();
        response.setId(savedBill.getId());
        response.setUserId(userEntity.getId()); //  savedBill.getUser().getId();

        return response;
    }

    public List<BillResponse> getBillsByUser(Long userId){
        List<BillsEntity> billsEntities = billRepository.findByUserId(userId);

        return billsEntities.stream().map(
            bill -> {
                BillResponse res = new BillResponse();
                res.setId(bill.getId());
                res.setUserId(bill.getUser().getId());
                return res;
            }
        ).collect(Collectors.toList());
    }
}
