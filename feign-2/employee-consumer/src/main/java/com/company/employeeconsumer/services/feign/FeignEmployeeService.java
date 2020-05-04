package com.company.employeeconsumer.services.feign;

import com.company.employeeconsumer.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name ="employe-producer")
public interface FeignEmployeeService {

    @PostMapping("/add")
    public Employee getEmployee();

    @PostMapping("/add-2")
    public ResponseEntity<Employee> getEmployee2();

}
