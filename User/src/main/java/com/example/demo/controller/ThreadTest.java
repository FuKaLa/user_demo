package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
    private static final Logger logger = LoggerFactory.getLogger(ThreadTest.class);
    private static final ExecutorService pool = Executors.newFixedThreadPool(50);


    public static void main(String[] args) {
        new HashMap();
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                logger.info(Thread.currentThread().getName() + "——");

            });
        }
    }
}
