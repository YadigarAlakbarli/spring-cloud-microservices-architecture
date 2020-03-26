package com.company.feignclient.controller;

import com.company.feignclient.feignService.UserFeignService;
import com.company.feignclient.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserResourceController {

    @Autowired
    UserFeignService userFeignService;

    @GetMapping("/instance")
    public  String getInstanceId(){
     return   userFeignService.getInstanceId();
    }

    @GetMapping("/getall")
    public List<User> getAllUser(){
        return userFeignService.getAllUser();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
       return userFeignService.findById(id);
    }

    @PostMapping("/saveuser")
    public User saveUser(@RequestBody User user){
      return   userFeignService.saveUser(user);
    }
}
