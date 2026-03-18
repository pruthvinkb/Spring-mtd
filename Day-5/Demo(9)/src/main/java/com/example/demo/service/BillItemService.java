package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BillItemRequest;
import com.example.demo.dto.BillItemResponse;
import com.example.demo.entity.BillItemEntity;
import com.example.demo.entity.BillsEntity;
import com.example.demo.entity.ProductEntity;
import com.example.demo.repository.BillItemRepository;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class BillItemService {
    private final BillItemRepository billItemRepository;
    private final BillRepository billRepository;
    private final ProductRepository productRepository;
    public BillItemService(BillItemRepository billItemRepository, BillRepository billRepository,
            ProductRepository productRepository) {
        this.billItemRepository = billItemRepository;
        this.billRepository = billRepository;
        this.productRepository = productRepository;
    }

    public BillItemResponse addItem(BillItemRequest request){
        BillsEntity bill = billRepository.findById(request.getBillId()).orElseThrow();
        ProductEntity product = productRepository.findById(request.getProductId()).orElseThrow();

        double price = product.getProdMrp();
        double tax = product.getProdTax();

        double total = request.getQty() * price;
        total = total + (total * tax / 100);

        BillItemEntity item = new BillItemEntity();
        item.setBill(bill);
        item.setProduct(product);
        item.setQty(request.getQty());
        item.setPrice(price);
        item.setTax(tax);
        item.setTotal(total);

        BillItemEntity savedItem = billItemRepository.save(item);

        BillItemResponse response = new BillItemResponse();
        response.setId(savedItem.getId());
        response.setBillId(savedItem.getBill().getId());
        response.setProductId(savedItem.getProduct().getId());
        response.setQty(savedItem.getQty());
        response.setPrice(savedItem.getPrice());
        response.setTax(savedItem.getTax());
        response.setTotal(savedItem.getTotal());

        return response;
    }

    public List<BillItemResponse> getItemsbyBill(Long billId){
        List<BillItemEntity> items = billItemRepository.findByBillId(billId);

        return items.stream().map(
            item -> {
                BillItemResponse res = new BillItemResponse();
                res.setBillId(item.getBill().getId());
                res.setId(item.getId());
                res.setPrice(item.getPrice());
                res.setProductId(item.getProduct().getId());
                res.setQty(item.getQty());
                res.setTax(item.getTax());
                res.setTotal(item.getTotal());
                return res;
            }
        ).collect(Collectors.toList());
    } 
}
