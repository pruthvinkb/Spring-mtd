package com.example.productdb.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Customername;
    private int total;
    private double tax;
    private double grandtotal;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCustomername() {
        return Customername;
    }
    public void setCustomername(String customername) {
        Customername = customername;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public double getTax() {
        return tax;
    }
    public void setTax(double tax) {
        this.tax = tax;
    }
    public double getGrandtotal() {
        return grandtotal;
    }
    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }
}
