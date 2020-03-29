package com.company.orderservice.entity;

import lombok.Data;

@Data
public class Payment {
    private int id;
    private int orderId;
    private double amount;
    private boolean status;
}
