package com.example.billing.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "bill_id")
    @JsonBackReference
    private BillEntity bill;
    
    @Column(name = "prod_name")
    private String prodName;
    
    @Column(name = "prod_qty")
    private Integer prodQty;
    
    @Column(name = "prod_mrp")
    private BigDecimal prodMrp;
    
    @Column(name = "prod_tax")
    private BigDecimal prodTax;
    
    @Column(name = "prod_total")
    private BigDecimal prodTotal;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public BillEntity getBill() {
        return bill;
    }
    public void setBill(BillEntity bill) {
        this.bill = bill;
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