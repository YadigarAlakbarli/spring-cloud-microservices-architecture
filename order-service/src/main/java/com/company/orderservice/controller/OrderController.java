package com.company.orderservice.controller;


import com.company.orderservice.entity.Order;
import com.company.orderservice.entity.Payment;
import com.company.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Value("${app.id:Not Found App Info}")
    private String appInfo;

    @GetMapping("/info")
    public String getInfo(){
       return  appInfo;
    }

    @PostMapping("/buyorder")
    public Payment buyOrder(@RequestBody Order order){
       return orderService.buyOrder(order);
    }
}
