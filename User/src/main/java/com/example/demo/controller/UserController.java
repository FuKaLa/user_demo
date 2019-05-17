package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.Utils;
import com.example.demo.entity.IncomeSumPojo;
import com.example.demo.entity.Invoice;
import com.example.demo.service.UserService;
import com.example.demo.utils.SinochemConfig;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;


@Controller
@RequestMapping("/user")
public class UserController {

    /*@Autowired
    private UserService userService;
*/

  /*  @RequestMapping("/showUser")
    @ResponseBody
    public void selectUser () throws  Exception{
        userService.selectUser();
        userService.doTaskOne();
        userService.doTaskTwo();
        userService.doTaskThree();
    }*/

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        Map map = new HashMap();
        map.put("name", "马闯");
        map.put("sex", "男");
        map.put("age", "19");
        modelAndView.addObject("list", map);
        modelAndView.addObject("list2", "这是第二个集合");
        ;

        return modelAndView;
    }
    /*public static void main(String [] args){
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            String url = "jdbc:oracle:thin:@172.16.22.10:1521:ecologyzd";
            System.out.println(url);
            Connection coon = DriverManager.getConnection(url,"ecology","weaverzd");
            System.out.println(coon);
        }catch(Exception e){
            e.printStackTrace();
        }

    }*/


    @RequestMapping("/showUser")
    @ResponseBody
    public void selectUser(HttpServletRequest request) {
        String contexPath= request.getSession().getServletContext().getRealPath("/uplade/test-errer.log");
        System.out.println(contexPath);
    }

    /*public static void main(String[] args) {
        *//**获取单词，并且去重**//*
        List<String> list = Arrays.asList("hello welcome", "world hello", "hello world",
                "hello world welcome");
*//*
        //map和flatmap的区别
        list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------- ");
        list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList()).forEach(System.out::println);

        //实际上返回的类似是不同的
        List<Stream<String>> listResult = list.stream().map(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());
        List<String> listResult2 = list.stream().flatMap(item -> Arrays.stream(item.split(" "))).distinct().collect(Collectors.toList());

        System.out.println("---------- ");

        //也可以这样
        list.stream().map(item -> item.split(" ")).flatMap(Arrays::stream).distinct().collect(Collectors.toList()).forEach(System.out::println);

        System.out.println("================================================");*//*

        */

    /**
     * 相互组合
     **//*
        List<String> list2 = Arrays.asList("hello", "hi", "你好");
        List<String> list3 = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliu");

        list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);
        list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList()).forEach(System.out::println);//实际上返回的类似是不同的
        List<Stream<String>> list2Result = list2.stream().map(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());
        List<String> list2Result2 = list2.stream().flatMap(item -> list3.stream().map(item2 -> item + " " + item2)).collect(Collectors.toList());



    }
*/
    @Test
    public void test15() {


        /*System.out.println("Languages which ends with a ");
        filter(languages, (str) -> ((String) str).endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> ((String) str).length() > 4);*/

    }


    /*    public static void main(String[] args) {
         *//*   String Bphone = null;
        Map map = new HashMap();
        if (map.get("phone")!=null && !"null".equals(String.valueOf(map.get("phone")))){
            if(String.valueOf(map.get("phone")).length()==11){
                map.put("phone",String.valueOf(map.get("phone")).replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
            }

        }
        System.out.println(map.get("phone"));*//*


       *//* Map deptMap=  new HashMap();
        deptMap.put("OUNAME","闽侯白沙加油站");
        deptMap.put("ORGTYPE",4);
        deptMap.put("phone","18210635895");
        if(deptMap.get("phone")!=null || !"null".equals(String.valueOf(deptMap.get("phone")))){
            if (String.valueOf(deptMap.get("phone")).length() == 11) {
                deptMap.put("phone", String.valueOf(deptMap.get("phone")).replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2"));
            }
        }
        System.out.println(deptMap);
        Date date = new Date();*//*

    }*/
   /* public static void main(String[] args) {
        List retList = new ArrayList();
        retList.add(7);
        retList.add(6);
        retList.add(5);
        retList.add(4);
        retList.add(3);
        retList.add(2);
        for (int i = 0; i < retList.size(); i++) {

                    System.out.println(retList.get(i));
                    System.out.println("111111111");
                }
        }*/

    public static void send() {
        IncomeSumPojo i1 = new IncomeSumPojo("1", "张三", "男", 0.8);
        IncomeSumPojo i2 = new IncomeSumPojo("2", "李四", "女", 2.8);
        IncomeSumPojo i3 = new IncomeSumPojo("3", "王五", "男", 2.3);

        List<IncomeSumPojo> list = new ArrayList();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        Collections.sort(list, Comparator.comparing(IncomeSumPojo::getSurplus_num));
        System.out.println(list);

        //list.add(i3);
        //Map<String, List<IncomeSumPojo>> collect = list.stream().collect(Collectors.groupingBy(IncomeSumPojo::getSex));
        /*Map<String, List<IncomeSumPojo>> tempMap = Stream.of(new IncomeSumPojo("1", "aa", "男"), new IncomeSumPojo("1", "bb", "男"), new IncomeSumPojo("3", "cc", "女"))
                .collect(Collectors.groupingBy(x -> x.getSex()));*/
        /*for (String s : tempMap.keySet()) {
            tempMap.get(s).stream().forEach(x -> System.out.println(x));
        }*/
       /* Map<String, List<IncomeSumPojo>> collect = list.stream().collect(Collectors.groupingBy(IncomeSumPojo::getSex));
        System.out.println(collect.get("女"));
        List<IncomeSumPojo> lists = collect.get("女");
        System.out.println(lists);
        List<IncomeSumPojo> surplusPoints = new ArrayList<>();
        surplusPoints.addAll(list);
        Double surplusNum = surplusPoints.parallelStream().mapToDouble(IncomeSumPojo::getSurplus_num).reduce(Double::max).getAsDouble();
        *//*BigDecimal b = new BigDecimal(surplusNum);
        Double d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();*//*
        //System.out.println(d);
        System.out.println(surplusNum);*/

    }

    public static void main(String[] args) throws Exception {
        /*System.out.println("5215556495534880645".substring(0, 2));
        JSONObject msg = new JSONObject();
        msg.put("OPEN_TICKET_TYPE","0");
        if(!"0".equals(msg.getString("OPEN_TICKET_TYPE")) && !"1".equals(msg.getString("OPEN_TICKET_TYPE"))){
            System.out.println("11111111");
        }*/

        //List<Invoice.RequestBean> cards = invoice.getCards();
        //Invoice.RequestBean requestBean = cards.get(0);
        /*if (invoice.getCards().size() == 0) {
            System.out.println("qqqqqq");
        }

        DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        String aa = "1999-03-03";
        System.out.println(format1.format(aa));*/
       /* Map map1 = new HashMap();
        map1.put("q","1");
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        map1.put("list",list.toString());
        String result = Utils.send("http://boss.uat.xhjiayou.cn/api/kaorderapi"+"/join/order",map1);
        System.out.println(result);*/
        //Map map1 = new HashMap();
       //map1.put("card_id","pDpwWwCQpCtMa7oQrGAu_Qh0354s");
        //String result = Utils.doPostJson("https://api.weixin.qq.com/card/delete?access_token=21_CMT6IxfYEVK3dYFstoXoCgAeU47q639W_a45f18jJH268xqX2xQfck2JxI6jm-JNkdApD5odEjWZvmX1PXmXo8gQCir1aRgjqw7BG9L8WKDpNnjWwXy5H1-5eU5Jsl2zp6jPCbiHxDCkGtl-NAWfAFAERN", JSONObject.toJSONString(map1));
        //String result = Utils.send("https://api.weixin.qq.com/card/delete?access_token=21_XNbcgFpbUqALtENWbiCjDin_0xwq1ucBv8KK3dRwWSOtce_o51pqo7lK16L5ic09dVHV8DPOu5hGUOgQL0283O2Pc9SxTliig43oX-mxf8EhZ11xfhcZ7CgwEl1WO9fFxpzAvia9eskTjqmHWZBhAGADGI",map1);
        //System.out.println(result);
        String ecard_url = SinochemConfig.getString("sinochem.ecard.url");
        System.out.println(ecard_url);


                /*String time = "201-02-16T08:17:21.000+0000";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSZ");
        Date result;
        result = df.parse(time);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(sdf.format(result));
*/




        /*String a = ".1";
        System.out.println(new BigDecimal(".1"));*/
        /*IncomeSumPojo i1 = new IncomeSumPojo("1", "2019-04-16 09:54:58", "男", 0.8);
        IncomeSumPojo i2 = new IncomeSumPojo("2", "2019-04-16 09:54:19", "女", 2.8);
        IncomeSumPojo i3 = new IncomeSumPojo("3", "2019-04-16 09:58:52", "男", 2.3);
        User u1 =  new User("1","2","3");
        User u2 =  new User("2","2","3");
        User u3 =  new User("3","2","3");
        List<IncomeSumPojo> list = new ArrayList();
        list.add(i1);
        list.add(i2);
        list.add(i3);
        List<User> users = new ArrayList();
        users.add(u1);
        users.add(u2);
        users.add(u3);









        for (IncomeSumPojo i : list) {
            for (User points : users) {
                if (i.getId().equals(points.getId())) {
                    System.out.println(i.getId()+"------"+points.getId());
                    continue;
                }else {
                    System.out.println("222222222");
                }
            }
        }*/

        /*Iterator<IncomeSumPojo> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        new String("");
        Map map = new HashMap();
        map.put("invoice_type", "2");
        if ("1".equals((String) map.get("invoice_type"))) {
            System.out.println("1111111111111");*/


        //TreeMap<String, List<IncomeSumPojo>> matchsListMap = list.stream() .collect(Collectors.groupingBy(IncomeSumPojo::getSex,TreeMap::new,Collectors.toList()));
        //send();
     /*   try {
            seng();
        }catch (Exception r){
            System.out.println(r.getMessage());
        }

    }*/

    /*public static String seng() throws Exception{
        String a ="1234";
        //System.out.println(1/0);
        if(a.equals("1234")) {
            throw new Exception("SSSSSS");
        }
        return "1111";
    }*/
   /* try {
        try {
            System.out.println(1/0);
        }catch (Exception e){
            System.out.println("123");
        }
        System.out.println("1234556");
    }catch (Exception r){

    }
    }*/
        /*String uuid = UUID.randomUUID().toString();    //获取UUID并转化为String对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
        System.out.println(uuid.replace("-", ""));
        System.out.println(simpleDateFormat.format(new Date()));*/

        //cardBalance = Double.valueOf(cardValueMap.get("cardBalance").toString());
       /* try {
            getUserService();
        }catch (Exception r){

        }*/


    }

    public static void getUserService() throws Exception {
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();

        hints.put(EncodeHintType.MARGIN, 0);

        BitMatrix bitMatrix = new QRCodeWriter().encode("http://baidu.com",

                BarcodeFormat.QR_CODE, 256, 256, hints);

        int width = bitMatrix.getWidth();

        int height = bitMatrix.getHeight();

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        for (int x = 0; x < width; x++) {

            for (int y = 0; y < height; y++) {

                image.setRGB(x, y, bitMatrix.get(x, y) == true ?

                        Color.BLACK.getRGB() : Color.WHITE.getRGB());

            }

        }

        ImageIO.write(image, "png", new File("D:\\yyxy\\a.png"));
    }

    @RequestMapping("/test")
    public static void dowanload(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //二维码中包含的信息
        String content = "姓名:十二余\n博客：https://www.cnblogs.com/jing5464";
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        // 指定编码格式
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        // 指定纠错级别(L--7%,M--15%,Q--25%,H--30%)
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
        // 编码内容,编码类型(这里指定为二维码),生成图片宽度,生成图片高度,设置参数
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 200, 200, hints);
        //设置请求头
        response.setHeader("Content-Type", "application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + "十二余的二维码.png");
        OutputStream outputStream = response.getOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "png", outputStream);
        outputStream.flush();
        outputStream.close();
    }

    private static void ListSort(List<IncomeSumPojo> list) {
        Collections.sort(list, new Comparator<IncomeSumPojo>() {
            @Override
            public int compare(IncomeSumPojo o1, IncomeSumPojo o2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    Date dt1 = format.parse(o1.getName());
                    Date dt2 = format.parse(o2.getName());
                    if (dt1.getTime() < dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() > dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }
};