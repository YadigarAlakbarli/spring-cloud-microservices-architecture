package com.company.paymentservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class Order {
    private int id;
    private  String name;
    private double amount;
    private int quantity;
}
