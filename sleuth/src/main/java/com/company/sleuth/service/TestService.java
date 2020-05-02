package com.company.sleuth.service;

import com.company.sleuth.controller.TestController;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    private static Log logger= LogFactory.getLog(TestService.class);

    public void doSomeWorkSameSpan() throws InterruptedException {
        Thread.sleep(1000L);
        logger.info("Doing some work");
    }
}
