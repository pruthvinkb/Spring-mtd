package com.example.productdb.dto.request;

import java.util.List;

public class ProductRequest {
    private String customername;
    private List<Integer> product;
    public String getCustomername() {
        return customername;
    }
    public void setCustomername(String customername) {
        this.customername = customername;
    }
    public List<Integer> getProduct() {
        return product;
    }
    public void setProduct(List<Integer> product) {
        this.product = product;
    }
}
