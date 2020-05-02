package com.company.sleuth.controller;

import com.company.sleuth.service.TestService;
import com.company.sleuth.thread.TestRunnable;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Executor;
import java.util.logging.Logger;

@RestController
public class TestController {
    @Autowired
    TestService testService;
    @Autowired
    private Executor executor;
 private static Log logger= LogFactory.getLog(TestController.class);

    @GetMapping("/")
    public String helloSleuth() throws InterruptedException {
        logger.info("Hello Sleuth");
        return "success";
    }

    @GetMapping("/same-span")
    public String helloSleuthSameSpan() throws InterruptedException {
        logger.info("Same Span");
        testService.doSomeWorkSameSpan();
        return "success";
    }



    @GetMapping("/new-thread")
    public String helloSleuthNewThread() {
        logger.info("New Thread");
        TestRunnable runnable=new TestRunnable();
        executor.execute(runnable);

        logger.info("I'm done - with the original span");
        return "success";
    }
}
