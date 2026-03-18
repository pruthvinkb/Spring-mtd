package com.example.billing.dto.response;

import java.util.List;

public class BillResponse {
    private Long id;
    private UserResponse user;
    private List<ProductResponse> products;

    public BillResponse() {}

    public BillResponse(Long id, UserResponse user, List<ProductResponse> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UserResponse getUser() {
        return user;
    }
    public void setUser(UserResponse user) {
        this.user = user;
    }
    public List<ProductResponse> getProducts() {
        return products;
    }
    public void setProducts(List<ProductResponse> products) {
        this.products = products;
    }
}