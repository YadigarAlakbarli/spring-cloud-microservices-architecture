package com.company.userapi.controller;

import com.company.userapi.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
}
