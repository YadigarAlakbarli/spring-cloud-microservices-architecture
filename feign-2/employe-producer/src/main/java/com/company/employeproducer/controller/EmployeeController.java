package com.company.employeproducer.controller;

import com.company.employeproducer.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired
    private Environment env;

    @GetMapping("/")
    public String home(){
        return  env.getProperty("eureka.instance.instance-id");
    }

    @PostMapping("/add")
    public Employee getEmployee(){
        Employee employee=new Employee(1,"Yadigar","Elekberli",24,"IT",1200);
        return employee;
    }

    @PostMapping("/add-2")
    public ResponseEntity<Employee> getEmployee2(){
        Employee employee=new Employee(1,"Yadigar","Elekberli",24,"IT",1200);
        return ResponseEntity.ok(employee);
    }
}
