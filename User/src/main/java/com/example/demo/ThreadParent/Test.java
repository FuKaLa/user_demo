package com.example.demo.ThreadParent;

import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-12-18 13:18
 **/
public class Test {


    public static void main(String[] args) throws ParseException {
//        ExecutorService executor = Executors.newCachedThreadPool();
//
//        Future<String> future = executor.submit(() -> { //Lambda 是一个 callable， 提交后便立即执行，这里返回的是 FutureTask 实例
//            System.out.println("running task");
//            Thread.sleep(10000);
//            return "return task";
//        });
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
//
//        System.out.println("do something else"); //前面的的 Callable 在其他线程中运行着，可以做一些其他的事情
//
//        try {
//            System.out.println(future.get()); //等待 future 的执行结果，执行完毕之后打印出来
//        } catch (InterruptedException e) {
//        } catch (ExecutionException e) {
//
//        } finally {
//            executor.shutdown();
//        }

       String test  = "";
       if(StringUtils.isNotBlank(test)&&test.length()>=4){
           System.out.println(test.substring(test.length()-4,test.length()));
       }
    }
}
