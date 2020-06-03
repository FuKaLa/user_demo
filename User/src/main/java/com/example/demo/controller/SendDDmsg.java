package com.example.demo.controller;

import com.example.demo.utils.SendHttps;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class SendDDmsg {
    public static void main(String[] args){
//
//        // 钉钉的webhook
//        String dingDingToken="https://oapi.dingtalk.com/robot/send?access_token=7f30626219b39c1fadc4875f065a2a69c63256806760192d58840b7b3cbff5a6";        // 请求的JSON数据，这里我用map在工具类里转成json格式
//
//        Map<String,Object> json=new HashMap();
//        Map<String,Object> text=new HashMap();
//        json.put("msgtype","link");
//        text.put("text","刚刚上传了\"+11+\"条 的回款信息，请点击查看详情");
//        text.put("messageUrl","www.baidu.com");
//        text.put("title","内容");
//        text.put("picUrl","http://img125.nipic.com/file/20190911/28918767_200220146000_1.jpg");
//        json.put("link",text);
//        // 发送post请求
//        String response = SendHttps.sendPostByMap(dingDingToken, json);
//        System.out.println("相应结果："+response);
        BigDecimal bigDecimal = new BigDecimal(0.16);
        int i = bigDecimal.multiply(new BigDecimal(100)).intValue();
        System.out.println(i);
    }
}
