package com.company.feignclient.proxy;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-api")
public interface UserApi {

}
