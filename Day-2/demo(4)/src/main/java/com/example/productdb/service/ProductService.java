package com.example.productdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.productdb.dto.request.ProductRequest;
import com.example.productdb.dto.responce.ProductResponce;
import com.example.productdb.entity.Product;
import com.example.productdb.repository.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductResponce processproduct(ProductRequest request){
        int total = request.getProduct().stream().mapToInt(Integer::intValue).sum();
        double tax = total * 0.18; // 18% tax
        double grandtotal = total + tax;

        Product product = new Product();

        product.setCustomername(request.getCustomername());
        product.setTotal(total);
        product.setTax(tax);
        product.setGrandtotal(grandtotal);

        productRepository.save(product);

        return new ProductResponce(request.getCustomername(), total, tax, grandtotal);
    }

    public List<ProductResponce> getAllProductResult(){
        return productRepository.findAll().stream()
                .map(product -> new ProductResponce(product.getCustomername(), 
                product.getTotal(), product.getTax(), product.getGrandtotal()))
                .toList();
    }
}
