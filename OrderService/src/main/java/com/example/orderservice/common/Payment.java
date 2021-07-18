package com.example.orderservice.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    private int payment_id;
    private String transaction_id;
    private String status;
    private int order_id;
    private double amount;
}
