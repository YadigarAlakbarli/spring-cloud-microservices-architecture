package com.company.employeeconsumer.controller;

import com.company.employeeconsumer.services.feign.FeignEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private Environment env;
    @Autowired
    FeignEmployeeService feignEmployeeService;

    @GetMapping("/")
    public String home(){
        return  env.getProperty("app.id");
    }

    @GetMapping("/getemployee")
    public String getEmployee(){
        return  feignEmployeeService.getEmployee().getName();
    }

    @GetMapping("/getemployee-2")
    public String getEmployee2(){
        return  feignEmployeeService.getEmployee2().getBody().getName();
    }
}
