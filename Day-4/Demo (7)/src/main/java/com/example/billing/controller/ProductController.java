package com.example.billing.controller;

import com.example.billing.dto.request.ProductRequest;
import com.example.billing.dto.response.ApiResponse;
import com.example.billing.entity.ProductEntity;
import com.example.billing.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductRequest request) {
        ProductEntity product = new ProductEntity();
        product.setProdName(request.getProdName());
        product.setProdQty(request.getProdQty());
        product.setProdMrp(request.getProdMrp());
        product.setProdTax(request.getProdTax());
        
        ProductEntity savedProduct = productService.addProductToBill(request.getBillId(), product);
        if (savedProduct != null) {
            return ResponseEntity.ok(new ApiResponse("Product added successfully", true, savedProduct));
        }
        return ResponseEntity.badRequest().body(new ApiResponse("Bill not found", false, null));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> getAllProducts() {
        List<ProductEntity> products = productService.getAllProducts();
        return ResponseEntity.ok(new ApiResponse("Products retrieved successfully", true, products));
    }

    @GetMapping("/bill/{billId}")
    public ResponseEntity<ApiResponse> getProductsByBillId(@PathVariable Long billId) {
        List<ProductEntity> products = productService.getProductsByBillId(billId);
        return ResponseEntity.ok(new ApiResponse("Bill products retrieved", true, products));
    }
}