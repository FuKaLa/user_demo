package com.example.demo.entity;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-09-19 16:46
 **/
public class DD {
    public static void main(String[] args) {
//        List<String> list1 = new ArrayList<String>();
//        list1.add("1");
//        list1.add("2");
//        list1.add("3");
//        list1.add("5");
//        list1.add("6");
//
//        List<String> list2 = new ArrayList<String>();
//        list2.add("2");
//        list2.add("3");
//        list2.add("7");
//        list2.add("8");
//
//        // 交集
//        List<String> intersection = list1.stream().filter(item -> list2.contains(item)).collect(toList());
//        System.out.println("---交集 intersection---");
//        intersection.parallelStream().forEach(System.out :: println);

        List<User> list = new ArrayList<>();
        list.add(new User(1, "小红", "重庆"));
        list.add(new User(2, "小绿", "北京"));
        list.add(new User(3, "小粉", "广州"));
        list.add(new User(4, "小红", "重庆"));
        list.add(new User(5, "小红", "重庆"));

//        public class StreamTest2 {
//
//            public static void main(String[] args) {
//
//
//                Record o1 = new Record("hg", "沙县小吃", new BigDecimal(12));
//
//                Record o2 = new Record("hg", "沙县小吃", null);
//
//                Record o3 = new Record("hg", "沙县小吃", new BigDecimal(1));
//
//                Record o4 = new Record("hg", "沙县小吃", new BigDecimal(5));
//
//                List<Record> orders = Lists.newArrayList();
//
//                orders.add(o1);
//                orders.add(o2);
//                orders.add(o3);
//                orders.add(o4);
//
//                Map<String, BigDecimal> collect2 = orders.stream()
//                        .collect(groupingBy(Record::getGoodsCode, reducing(new BigDecimal("0"), <span style="color: #FF0000;">(a, b) -></span>  , (ele1, ele2) -> ele1.add(ele2))));
//
//                System.out.println(collect2);
//
//            }
//
//        }


        Map<String, IntSummaryStatistics> collect = list.stream().collect(Collectors.groupingBy(User::getName, Collectors.summarizingInt(User::getId)));
        System.out.println(collect);

    }



}
