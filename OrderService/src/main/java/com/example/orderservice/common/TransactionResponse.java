package com.example.orderservice.common;

import com.example.orderservice.Model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private Order order;
    private String transaction_id;
    private double amount;
    String message;
}
