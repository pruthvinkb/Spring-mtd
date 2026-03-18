package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductRequest;
import com.example.demo.dto.ProductResponse;
import com.example.demo.entity.BillsEntity;
import com.example.demo.entity.ProductsEntity;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final BillRepository billRepository;
    public ProductService(ProductRepository productRepository, BillRepository billRepository) {
        this.productRepository = productRepository;
        this.billRepository = billRepository;
    }

    public ProductResponse createProduct(ProductRequest request){
        BillsEntity billsEntity = billRepository.findById(request.getBillId()).orElseThrow();

        double total = request.getProdQty() * request.getProdMrp();
        total = total + (total * request.getProdTax() / 100);

        ProductsEntity productsEntity = new ProductsEntity();
        productsEntity.setBill(billsEntity);
        productsEntity.setProdName(request.getProdName());
        productsEntity.setProdQty(request.getProdQty());
        productsEntity.setProdMrp(request.getProdMrp());
        productsEntity.setProdTax(request.getProdTax());
        productsEntity.setProdTotal(total);

        ProductsEntity savedProduct = productRepository.save(productsEntity);

        ProductResponse response = new ProductResponse();
        response.setId(savedProduct.getId());
        response.setBillId(billsEntity.getId());
        response.setProdName(savedProduct.getProdName());
        response.setProdQty(savedProduct.getProdQty());
        response.setProdMrp(savedProduct.getProdMrp());
        response.setProdTax(savedProduct.getProdTax());
        response.setProdTotal(savedProduct.getProdTotal());

        return response;
    }

    public List<ProductResponse> getProductsByBill(Long billId){
        List<ProductsEntity> productsEntities = productRepository.findByBillId(billId);

        return productsEntities.stream().map(
            product -> {
                ProductResponse res = new ProductResponse();
                res.setId(product.getId());
                res.setBillId(product.getBill().getId());
                res.setProdName(product.getProdName());
                res.setProdQty(product.getProdQty());
                res.setProdMrp(product.getProdMrp());
                res.setProdTax(product.getProdTax());
                res.setProdTotal(product.getProdTotal());
                return res;
            }
        ).collect(Collectors.toList());
    }

}
