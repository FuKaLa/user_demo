package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;


@Configuration
public class TestAop {


    public static void main(String[] args) {
        TestAop aop = new TestAop();
        Object add = aop.add(2, 0);
        System.out.println(add);
    }


    public Object add(int a,int b){
        if(b!=0){
            return a/b;
        }else {
            return "除数不可为0";
        }

    };

}
