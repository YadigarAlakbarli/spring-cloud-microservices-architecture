package com.company.paymentservice.repo;

import com.company.paymentservice.entity.Order;
import com.company.paymentservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
