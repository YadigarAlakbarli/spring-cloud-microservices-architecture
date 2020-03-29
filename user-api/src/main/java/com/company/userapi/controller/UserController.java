package com.company.userapi.controller;

<<<<<<< HEAD
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import com.company.userapi.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
>>>>>>> 8c66baee73e9259e0dac68ad2de482d840f4277c

@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${app.id}")
    private String id;

    private List<User> userList= Arrays.asList(
            new User(1,"Yadigar-1","yadigar.alakbarli@gmail.com","12345"),
            new User(2,"Yadigar-2","yadigar.alakbarli@gmail.com","12345"),
            new User(3,"Yadigar-3","yadigar.alakbarli@gmail.com","12345"),
            new User(4,"Yadigar-4","yadigar.alakbarli@gmail.com","12345"),
            new User(5,"Yadigar-5","yadigar.alakbarli@gmail.com","12345"));

    @GetMapping("/instance")
    public  String getInstanceId(){
        return "Your app id:"+id;
    }

<<<<<<< HEAD
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


=======
    @GetMapping("/getall")
    public List<User> getAllUser(){
        return userList;
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        User u=userList.stream().filter(user->user.getId()==id).findAny().orElse(null);
        if(u==null)
            return new ResponseEntity<User>(u, HttpStatus.NOT_FOUND);
        return new ResponseEntity<User>(u,HttpStatus.OK);
    }

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
        userList.add(user);
        return user;
    }
>>>>>>> 8c66baee73e9259e0dac68ad2de482d840f4277c
}
