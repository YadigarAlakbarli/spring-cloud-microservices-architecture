package com.company.employeproducer.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String surname;
    private int age;
    private String position;
    private double salary;
}
