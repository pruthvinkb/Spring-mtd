package com.example.productdb.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productdb.dto.request.ProductRequest;
import com.example.productdb.dto.responce.ApiResponce;
import com.example.productdb.dto.responce.ProductResponce;
import com.example.productdb.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/process")
    public ApiResponce<ProductResponce> processProduct(@RequestBody ProductRequest request) {
        ProductResponce responce = productService.processproduct(request);
        return new ApiResponce<>("success", responce);
    }

    @GetMapping("/results")
    public ApiResponce<List<ProductResponce>> getAllProductResults() {
        List<ProductResponce> responces = productService.getAllProductResult();
        return new ApiResponce<List<ProductResponce>>("success", responces);
    }
}
