package com.example.demo.controller;

import com.example.demo.utils.JedisManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class redisController {

    @RequestMapping("/index")
    @ResponseBody
    public void test(){
        JedisManager.getInstance().set("name","马闯");
        System.out.println(JedisManager.getInstance().get("name"));
    }

}
