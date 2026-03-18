package com.example.billing.service;

import com.example.billing.entity.BillEntity;
import com.example.billing.entity.ProductEntity;
import com.example.billing.repository.BillRepository;
import com.example.billing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private BillRepository billRepository;

    public ProductEntity createProduct(ProductEntity product) {
        // Calculate total: (MRP * Qty) + Tax
        BigDecimal total = product.getProdMrp()
            .multiply(BigDecimal.valueOf(product.getProdQty()))
            .add(product.getProdTax());
        product.setProdTotal(total);
        return productRepository.save(product);
    }

    public ProductEntity addProductToBill(Long billId, ProductEntity product) {
        Optional<BillEntity> bill = billRepository.findById(billId);
        if (bill.isPresent()) {
            product.setBill(bill.get());
            return createProduct(product);
        }
        return null;
    }

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public List<ProductEntity> getProductsByBillId(Long billId) {
        return productRepository.findByBillId(billId);
    }
}