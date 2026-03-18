package com.example.billing.dto.request;

import java.util.List;

public class BillWithProductsRequest {
    private Long userId;
    private List<ProductRequest> products;

    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public List<ProductRequest> getProducts() {
        return products;
    }
    public void setProducts(List<ProductRequest> products) {
        this.products = products;
    }
}