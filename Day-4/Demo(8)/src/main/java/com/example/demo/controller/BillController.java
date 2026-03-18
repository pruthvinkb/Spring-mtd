package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillRequest;
import com.example.demo.dto.BillResponse;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
    private final BillService billService;

    public BillController(BillService billService) {
        this.billService = billService;
    }
    
    @PostMapping
    public ApiResponse<BillResponse> createBill(@RequestBody BillRequest request){
        BillResponse response = billService.createBill(request);
        return new ApiResponse<BillResponse>("sucess", response);
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<BillResponse>> getBillsByUser(@PathVariable Long userId){
        List<BillResponse> responses = billService.getBillsByUser(userId);
        return new ApiResponse<List<BillResponse>>("success", responses);
    }

}
