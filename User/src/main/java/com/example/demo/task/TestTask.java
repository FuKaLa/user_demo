package com.example.demo.task;

import com.example.demo.service.DynamicScheduledTask;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TestTask extends DynamicScheduledTask {
    public static final Logger logger = Logger.getLogger(TestTask.class);
    @Override
    public void doBiz() {
        logger.info(Thread.currentThread().getId()+"---11111");
    }
}

