package com.example.billing.dto.response;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String prodName;
    private Integer prodQty;
    private BigDecimal prodMrp;
    private BigDecimal prodTax;
    private BigDecimal prodTotal;

    public ProductResponse() {}

    public ProductResponse(Long id, String prodName, Integer prodQty, 
                          BigDecimal prodMrp, BigDecimal prodTax, BigDecimal prodTotal) {
        this.id = id;
        this.prodName = prodName;
        this.prodQty = prodQty;
        this.prodMrp = prodMrp;
        this.prodTax = prodTax;
        this.prodTotal = prodTotal;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
    public BigDecimal getProdTotal() {
        return prodTotal;
    }
    public void setProdTotal(BigDecimal prodTotal) {
        this.prodTotal = prodTotal;
    }
}