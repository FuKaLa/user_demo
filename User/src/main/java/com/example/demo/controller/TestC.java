package com.example.demo.controller;

public class TestC {
    public static void main(String[] args) {
        // TODO: 2019/9/10 0010  
        String url = "/machaung/userInfo/save/add";
        String[] urls = url.split("/");
        StringBuffer urlEnd = new StringBuffer();
        for (int i = 2;i<urls.length;i++){
            urlEnd.append("/").append(urls[i]);
        }
        System.out.println(urlEnd);
    }
}
