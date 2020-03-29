package com.company.userapi.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/testhystrix/{id}")
    @HystrixCommand(fallbackMethod = "fallback_test", commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String testHysterix(@PathVariable int id) throws InterruptedException{
        Thread.sleep(1000);
        return  "respons success"+id;
    }

    private String fallback_test(int id) {
        return "response fail"+id;
    }


}
