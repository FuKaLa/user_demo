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
    public void test() {
        Map map = new HashMap<>();
        OrderRecharge o = new OrderRecharge();
        o.setBalanceAmount(new BigDecimal(1));
        o.setBarCode("1");
        map.put("1", o.toString());
        String count = JedisManager.getInstance().hmset("orderList", map);
        System.out.println(JedisManager.getInstance().hgetAll("orderList"));
        Set<String> keys = JedisManager.getInstance().hgetAll("orderList").keySet();
        List<OrderRecharge> orderRechargeMsgList = new ArrayList<OrderRecharge>();
        for (String key : keys
        ) {
            System.out.println(JSON.toJSONString(JedisManager.getInstance().hget("orderList", key)));
            orderRechargeMsgList.add(JSONObject.parseObject(JedisManager.getInstance().hget("orderList", key).replace("=", ":"), OrderRecharge.class));
        }
        for (OrderRecharge ass : orderRechargeMsgList
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
        String curren = "user/info";
        String url = "info";
        System.out.println(curren.contains(url));
    }
    public static boolean checkUrl(String currentUrl) {
        List<String> list = new ArrayList();
        list.add("/doLogin");
        list.add("/doLoginMicro");
        list.add("/userInfo");
        list.add("/getCaptcha");
        list.add("/callbackApprove/callback");
        list.add("/workhour/pcLogin");
        list.add("/workhour/corpId");
        for (String ignoneUrl: list
        ) {
            if(currentUrl.contains(ignoneUrl)){
                return true;
            }
        }
        return false;
    }
}