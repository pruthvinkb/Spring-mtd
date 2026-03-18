package com.example.billing.controller;

import com.example.billing.dto.request.BillRequest;
import com.example.billing.dto.request.BillWithProductsRequest;
import com.example.billing.dto.request.ProductRequest;
import com.example.billing.dto.response.ApiResponse;
import com.example.billing.entity.BillEntity;
import com.example.billing.entity.ProductEntity;
import com.example.billing.service.BillService;
import com.example.billing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    @Autowired
    private BillService billService;
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse> createBill(@RequestBody BillRequest request) {
        BillEntity bill = billService.createBill(request.getUserId());
        if (bill != null) {
            return ResponseEntity.ok(new ApiResponse("Bill created successfully", true, bill));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("User not found", false, null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllBills() {
        List<BillEntity> bills = billService.getAllBills();
        return ResponseEntity.ok(new ApiResponse("Bills retrieved successfully", true, bills));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getBillById(@PathVariable Long id) {
        Optional<BillEntity> bill = billService.getBillById(id);
        if (bill.isPresent()) {
            return ResponseEntity.ok(new ApiResponse("Bill found", true, bill.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse> getBillsByUserId(@PathVariable Long userId) {
        List<BillEntity> bills = billService.getBillsByUserId(userId);
        return ResponseEntity.ok(new ApiResponse("User bills retrieved", true, bills));
    }

    @PostMapping("/with-products")
    public ResponseEntity<ApiResponse> createBillWithProducts(@RequestBody BillWithProductsRequest request) {
        BillEntity bill = billService.createBill(request.getUserId());
        if (bill != null) {
            for (ProductRequest productReq : request.getProducts()) {
                ProductEntity product = new ProductEntity();
                product.setProdName(productReq.getProdName());
                product.setProdQty(productReq.getProdQty());
                product.setProdMrp(productReq.getProdMrp());
                product.setProdTax(productReq.getProdTax());
                productService.addProductToBill(bill.getId(), product);
            }
            Optional<BillEntity> updatedBill = billService.getBillById(bill.getId());
            return ResponseEntity.ok(new ApiResponse("Bill with products created successfully", true, updatedBill.get()));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("User not found", false, null));
    }
}