package com.example.paymentservice.service;

import com.example.paymentservice.model.Payment;
import com.example.paymentservice.repositary.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    public Payment doPayment(Payment payment) {
        payment.setTransaction_id(UUID.randomUUID().toString());
        payment.setStatus(paymentProcessing());
        return paymentRepo.save(payment);
    }

    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "failure";
    }

    public Payment findPaymentHistoryByOrderId(int payment_id) {
       return paymentRepo.findById(payment_id).get();
    }
}
