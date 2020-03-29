package com.company.paymentservice.controller;

import com.company.paymentservice.entity.Order;
import com.company.paymentservice.entity.Payment;
import com.company.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @Value("${app.id:Not Found App Info}")
    private String appInfo;

    @GetMapping("/info")
    public String getInfo(){
       return  appInfo;
    }

    @PostMapping("/buyorder")
    public Payment buyOrder(@RequestBody Order order){
        return paymentService.payOrer(order);
    }
}
