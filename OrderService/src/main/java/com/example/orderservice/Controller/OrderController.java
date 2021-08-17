package com.example.orderservice.Controller;

import com.example.orderservice.Model.Order;
import com.example.orderservice.Service.OrderService;
import com.example.orderservice.common.Payment;
import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.awt.print.Book;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;



    @PostMapping("/bookOrder")
    public TransactionResponse bookOrder(@RequestBody TransactionRequest transactionRequest) {

        return orderService.saveOrder(transactionRequest);
    }

    @PostMapping("/orderId")
    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }

}
