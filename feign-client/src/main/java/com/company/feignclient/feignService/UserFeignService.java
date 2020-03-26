package com.company.feignclient.feignService;

import com.company.feignclient.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("user-api")
public interface UserFeignService {

    @GetMapping("/user/getall")
    public List<User> getAllUser();

    @GetMapping("/user/instance")
    public  String getInstanceId();

    @GetMapping("/user/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable int id);

    @PostMapping("/user/saveuser")
    public User saveUser(@RequestBody User user);
}
