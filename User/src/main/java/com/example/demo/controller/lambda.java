package com.example.demo.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 【多线程操作实例】
 * mc/2019年6月12日
 */
public class lambda {
    private final static int a = 0;

    public static void main(String[] args) {
        //lambda.Move();
        VolatileDemo();
    }

    private static void Move() {

        ExecutorService executorService = null;
        Integer rows = 200;
        Integer total = 10000;
        executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i <= (total / rows) + 1; i++) {
            Integer index = i;
            Integer start = i * rows;
            Integer end = rows;
            executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(index + "-----" + start);
                    return Thread.currentThread().getName();
                }
            });
        }
    }

    private  static int id = 0;
    //volatile 关键字测试
    //private volatile static int id = 0;

    private static void VolatileDemo() {
        ExecutorService executorService = null;

        executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i <= 100; i++) {
            executorService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println(Thread.currentThread().getName());
                    System.out.println(id++);
                    return Thread.currentThread().getName();
                }
            });
        }
    }
}

