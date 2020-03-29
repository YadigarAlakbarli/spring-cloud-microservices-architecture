package com.company.orderservice.service;



import com.company.orderservice.entity.Order;
import com.company.orderservice.entity.Payment;
import com.company.orderservice.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    RestTemplate restTemplate;


    public Payment buyOrder(Order order){
        String url="http://API-GATEWAY/payment/buyorder";
        Payment pay=restTemplate.postForObject(url,order,Payment.class);
       // orderRepository.save(order);
        return pay;
    }

}
