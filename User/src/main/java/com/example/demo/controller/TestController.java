package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.utils.MD5EncodeUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;


public class TestController {
    public static void main(String[] args) throws Exception {


        /**
         * 正则表达式
         * 必须包含数字,字母(区分大小写),特殊字符,长度最少8位
         */
        /*String pattern = "^^(?![a-zA-z]+$)(?!\\d+$)(?![^\\W]+$)(?![a-zA-z\\d]+$)(?![a-zA-z!^\\W]+$)(?![\\d!\\W]+$)[a-zA-Z\\d!^\\W]{8,}$";
        String password = "^wwwweASFF12";
        System.out.println(Pattern.matches(pattern, password));*/
      /* Map mapPost =  new HashMap();
        mapPost.put("code","123");
        mapPost.put("card_id","123");
        mapPost.put("bonus","12343");
        Map mapPost1 = new HashMap();
        mapPost1.put("is_notify_bonus",false);
        mapPost.put("notify_optional",mapPost1);

        System.out.println(JSONObject.toJSONString(mapPost));*/
        /*String number = "7.0000000000000007E-2";


        Double code = 0.07;*/

        System.out.println(MD5EncodeUtil.myMD5Encode("8888116002000307337111111").substring(8,24));


        //System.out.println(Double.parseDouble(number));

      /* String a = "23a";
        String b = "1a123aaa";
        System.out.println(!b.contains(a));
        if("Abcd1234".contains("Abcda")){
            System.out.println("aaaa");
        }*/

        /*
        List list = new ArrayList<>();
        List<String> orederNolist = list.stream().map(o -> {
            if ("00".equals(o.getSrcCode())) {
                return o.getSrcCodeId();
            }
            return o.getOrderId();
        }).collect(Collectors.toList());*/
       /* String pwd = makeRandomPassword(8);
        System.out.println(pwd);*/
       /* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String time = "2019-06-06 00:00:00";
        String time2 = "2019-06-06 00:00:01";
        if (compare_date(time, time2) < 0) {
            System.out.println("1111");
        }*/
    }

    public static String makeRandomPassword(int len) {
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }

    public static int compare_date(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return 1;
            } else if (dt1.getTime() < dt2.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}


