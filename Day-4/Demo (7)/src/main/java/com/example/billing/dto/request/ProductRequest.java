package com.example.billing.dto.request;

import java.math.BigDecimal;

public class ProductRequest {
    private Long billId;
    private String prodName;
    private Integer prodQty;
    private BigDecimal prodMrp;
    private BigDecimal prodTax;

    // Default constructor
    public ProductRequest() {}

    // Constructor without billId (for use in BillWithProductsRequest)
    public ProductRequest(String prodName, Integer prodQty, BigDecimal prodMrp, BigDecimal prodTax) {
        this.prodName = prodName;
        this.prodQty = prodQty;
        this.prodMrp = prodMrp;
        this.prodTax = prodTax;
    }

    public Long getBillId() {
        return billId;
    }
    public void setBillId(Long billId) {
        this.billId = billId;
    }
    public String getProdName() {
        return prodName;
    }
    public void setProdName(String prodName) {
        this.prodName = prodName;
    }
    public Integer getProdQty() {
        return prodQty;
    }
    public void setProdQty(Integer prodQty) {
        this.prodQty = prodQty;
    }
    public BigDecimal getProdMrp() {
        return prodMrp;
    }
    public void setProdMrp(BigDecimal prodMrp) {
        this.prodMrp = prodMrp;
    }
    public BigDecimal getProdTax() {
        return prodTax;
    }
    public void setProdTax(BigDecimal prodTax) {
        this.prodTax = prodTax;
    }
}