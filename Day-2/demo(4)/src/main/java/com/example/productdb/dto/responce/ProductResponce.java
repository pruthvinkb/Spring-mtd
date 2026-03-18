package com.example.productdb.dto.responce;

public class ProductResponce {
    private String customername;
    private int total;
    private double tax;
    private double grandtotal;
    public ProductResponce(String customername, int total, double tax, double grandtotal) {
        this.customername = customername;
        this.total = total;
        this.tax = tax;
        this.grandtotal = grandtotal;
    }
    public String getCustomername() {
        return customername;
    }
    public void setCustomername(String customername) {
        this.customername = customername;
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
