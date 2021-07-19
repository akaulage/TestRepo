package com.example.apigateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class fallbackController {

    @RequestMapping("/orderFallBack")
    public Mono<String> orderServiceFallBack()
    {
        return Mono.just("Order service is taking to long to respond or its down,please try again later");
    }

    @RequestMapping("/paymentFallBack")
    public Mono<String> paymentServiceFallBack()
    {
        return Mono.just("Payment service is taking to long to respond or its down,please try again later");
    }
}
