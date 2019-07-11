package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.entity.OrderRecharge;
import com.example.demo.entity.OrderRechargeMsg;
import com.example.demo.utils.JedisManager;
import com.fasterxml.jackson.core.JsonFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

@RequestMapping("/user")
@Controller
public class redisController {

    @RequestMapping("/index")
    @ResponseBody
    public void test(){
        Map map = new HashMap<>();
        OrderRecharge o = new OrderRecharge();
        o.setBalanceAmount(new BigDecimal(1));
        o.setBarCode("1");
        map.put("1",o.toString());
        String count = JedisManager.getInstance().hmset("orderList",map);
        System.out.println(JedisManager.getInstance().hgetAll("orderList"));
        Set<String> keys = JedisManager.getInstance().hgetAll("orderList").keySet();
        List<OrderRecharge> orderRechargeMsgList = new ArrayList<OrderRecharge>();
        for (String key:keys
             ) {
            System.out.println(JSON.toJSONString(JedisManager.getInstance().hget("orderList",key)));
            orderRechargeMsgList.add(JSONObject.parseObject(JedisManager.getInstance().hget("orderList",key).replace("=",":"),OrderRecharge.class));
        }
        for (OrderRecharge ass:orderRechargeMsgList
             ) {
            System.out.println(ass);
        }
      //  System.out.println(JedisManager.getInstance().hgetAll("orderList"));

       /* List<OrderRechargeMsg> orderRechargeMsgList = JSON.toJSONString(, OrderRechargeMsg.class);
        System.out.println(orderRechargeMsgList);
        System.out.println(count);
        System.out.println(JSONObject.toJSON(JedisManager.getInstance().hgetAll("orderList")));


        System.out.println(JSONObject.toJSON(JedisManager.getInstance().hgetAll("orderList")));*/



    }

    public static void main(String[] args) {
        String t = "{\"orderType\":\"0\",\"stationCode\":\"F006\",\"workday\":\"2019-06-12\",\"orderId\":\"\",\"payTime\":1560488504305,\"rebateAmount\":0.0000,\"rechargeStatus\":\"00\",\"transChannel\":\"00\",\"modifier\":\"admin\",\"cardNo\":\"8888118001000289808\",\"termId\":\"321001000001\",\"password\":\"111111\",\"modifyTime\":1560488504567,\"payAmount\":1,\"payType\":\"00\",\"srcOrderId\":\"5815604885043580654\",\"stationName\":\"\",\"creator\":\"admin\",\"payGetway\":\"8\",\"cardType\":3,\"balanceAmount\":2449.35,\"payAccount\":\"8888118001000289808\",\"userId\":\"admin\",\"srcType\":1,\"barCode\":\"\",\"createTime\":1560488504794,\"tenantId\":\"1200000001\",\"srcCode\":\"01\",\"userType\":20,\"invoiceStatus\":0,\"ticketId\":\"130146176\",\"shiftNo\":\"1\",\"status\":\"00\"}\"";;
        JSONObject.parseObject(t,OrderRecharge.class);
    }

}
