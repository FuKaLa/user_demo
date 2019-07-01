package com.example.demo.controller;

import java.util.Base64;

/**
 * 使用base64简单加盐加密
 */
public class url加密 {


    public static void main(String[] args){
        String salt = "abcd1234";
        String originalInput = "www.baidu.com";
        originalInput = originalInput +salt;
        String encodedString = Base64.getEncoder().encodeToString(originalInput.getBytes());
        System.out.println("原文为------>"+originalInput);
        System.out.println("加密完后---->"+encodedString);
        System.out.println("解密完后---->"+new String(Base64.getDecoder().decode(encodedString)));
        //解密完以后把盐值截取调
    }
}
