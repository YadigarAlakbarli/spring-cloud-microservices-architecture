package com.company.paymentservice.service;



import com.company.paymentservice.entity.Order;
import com.company.paymentservice.entity.Payment;
import com.company.paymentservice.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;


   public Payment payOrer(Order order){
       Payment payment=new Payment();
       payment.setStatus(getRandomStatus());
       payment.setAmount(order.getAmount());
       payment.setOrderId(order.getId());
     return  payment ;// paymentRepository.save(payment);
   }

    private boolean getRandomStatus(){
     return  new Random().nextBoolean();
    }
}
