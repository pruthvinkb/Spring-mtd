package com.example.demo.dto;

import lombok.Data;

@Data
public class BillItemRequest {
    private Long billId;
    private Long productId;
    private Integer qty;
}

// {
//     "billId": 1,
//     "productId": 4,
//     "qty": 2
// }