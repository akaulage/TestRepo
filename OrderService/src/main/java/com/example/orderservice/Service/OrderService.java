package com.example.orderservice.Service;

import com.example.orderservice.Model.Order;
import com.example.orderservice.Repositary.OrderRepo;
import com.example.orderservice.common.Payment;
import com.example.orderservice.common.TransactionRequest;
import com.example.orderservice.common.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    RestTemplate restTemplate;

    public Order getOrderById(int id) {

        return orderRepo.findById(id).get();
    }

    public List<Order> getAllOrder() {
        return orderRepo.findAll();
    }

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
        String message;
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrder_id(order.getOrder_id());
        payment.setAmount(order.getOrder_price());
        //rest call
        //Payment paymentResponse=restTemplate.postForObject("http://localhost:8091/payment/dopayment",payment,Payment.class);

        //instead of giving full url give the application name
        Payment paymentResponse = restTemplate.postForObject("http://Payment-Service/payment/dopayment", payment, Payment.class);

        message = paymentResponse.getStatus().equals("success") ? "Payment done successfully" : "Payment failure";

        orderRepo.save(order);
        return new TransactionResponse(order, paymentResponse.getTransaction_id(), paymentResponse.getAmount(), message);
    }
}
