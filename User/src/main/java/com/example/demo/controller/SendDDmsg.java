package com.example.demo.controller;

import com.example.demo.utils.SendHttps;

import java.util.HashMap;
import java.util.Map;

public class SendDDmsg {
    public static void main(String[] args){

        // 钉钉的webhook
        String dingDingToken="https://oapi.dingtalk.com/robot/send?access_token=7f30626219b39c1fadc4875f065a2a69c63256806760192d58840b7b3cbff5a6";        // 请求的JSON数据，这里我用map在工具类里转成json格式

        Map<String,Object> json=new HashMap();
        Map<String,Object> text=new HashMap();
        json.put("msgtype","text");
        text.put("content","这是一条测试推送钉钉消息");
        json.put("text",text);
        // 发送post请求
        String response = SendHttps.sendPostByMap(dingDingToken, json);
        System.out.println("相应结果："+response);

    }
}
