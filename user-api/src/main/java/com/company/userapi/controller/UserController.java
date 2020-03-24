package com.company.userapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${app.id}")
    private String id;

    @GetMapping("/instance")
    public  String getInstanceId(){
        return "Your app id:"+id;
    }
}
