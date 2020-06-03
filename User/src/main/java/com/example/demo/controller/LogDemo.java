package com.example.demo.controller;

import com.alibaba.fastjson.JSONArray;
import com.example.demo.utils.MySlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-09-25 15:13
 **/
public class LogDemo {
    private static final Logger logger = LoggerFactory.getLogger(LogDemo.class);

    public static void main(String[] args) {
        logger.info("s----{}----{}","这是一个字符串","第二个字符串");
        MySlf4j.textInfo("这是封装日志{}",1);
        MySlf4j.textInfo("这是封装日志{}",1);
    }
}
