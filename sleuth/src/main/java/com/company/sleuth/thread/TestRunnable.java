package com.company.sleuth.thread;

import com.company.sleuth.controller.TestController;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class TestRunnable  implements Runnable{
    private static Log logger= LogFactory.getLog(TestController.class);

    @Override
    public void run() {
        logger.info("New Thread");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            logger.info("I'm inside the new thread - with a new span");

    }
}
