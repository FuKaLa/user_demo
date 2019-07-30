package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/getUserDetailListExcel", method = RequestMethod.GET)
    public Object getUserDetailListExcel(HttpServletResponse response, HttpServletRequest request) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Map param = null;

            param = ExcelUtils.checkExcel(request);
            int size = 0;
            List<Map<String, Object>> returnInfo = null;
            try {
                response.setContentType("application/vnd.ms-excel;charset=UTF-8");
                ServletOutputStream outer = response.getOutputStream();
                String fileName = "fileName";
                fileName = fileName + ".xls";
                response.setHeader("Content-Disposition", "attachment;filename="
                        .concat(String.valueOf(URLEncoder.encode(fileName, "UTF-8"))));
                String[] titles = {""};
                //第一步，创建一个workbook，对应一个Excel文件
                XSSFWorkbook workbook = new XSSFWorkbook();
                //HSSFWorkbook workbook = new HSSFWorkbook();
                SXSSFWorkbook sxssfWorkbook = new SXSSFWorkbook(workbook, 100);
//            sxssfWorkbook.
                //第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
                SXSSFSheet sxssfSheet = (SXSSFSheet) sxssfWorkbook.createSheet("test");
                //sxssfSheet.setRandomAccessWindowSize(-1);
//            XSSFSheet hssfSheet = workbook.getSheet("sheet1");
                //第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short
                SXSSFRow sxssfRow = (SXSSFRow) sxssfSheet.createRow(0);
                //第四步，创建单元格，并设置值表头 设置表头居中
                XSSFCellStyle xssfCellStyle = workbook.createCellStyle();
                //居中样式
                xssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                SXSSFCell sxssfCell = null;
                for (int i = 0; i < titles.length; i++) {
                    sxssfCell = (SXSSFCell) sxssfRow.createCell(i);//列索引从0开始
                    sxssfCell.setCellValue(titles[i]);//列名1
                    sxssfCell.setCellStyle(xssfCellStyle);//列居中显示
                }
                //分页导出的总页数
                int count = 0;
                long length = 0;
                if (count < 10000) {
                    length = 1;
                } else {
                    length = (count % 10000 == 0 ? (count / 10000) : (count / 10000 + 1));
                }
                for (int j = 0; j < length; j++) {
                    //分页查询导出的数据
                    returnInfo = userService.getUserDetailListExcel(param, (j * 10000), 10000);
                    if (returnInfo != null && !returnInfo.isEmpty()) {
                        for (int i = 0; i < returnInfo.size(); i++) {
                            String userName = "";
                            String nikeName = "";
                            String phone = "";
                            String user_grade = "";
                            String sex = "";
                            String birthday = "";
                            String ouname = "";
                            String create_time = "";
                            sxssfRow = (SXSSFRow) sxssfSheet.createRow(++size);
                            Map map = returnInfo.get(i);
                            //会员名称
                            if (map.get("user_name") != null) {
                                userName = String.valueOf(map.get("user_name"));
                            }
                            sxssfRow.createCell(0).setCellValue(userName);
                            //微信昵称
                            if (map.get("nick_name") != null) {
                                nikeName = String.valueOf(map.get("nick_name"));
                            }
                            sxssfRow.createCell(1).setCellValue(nikeName);
                            //用户手机号
                            if (map.get("phone") != null) {
                                phone = String.valueOf(map.get("phone"));
                            }
                            sxssfRow.createCell(2).setCellValue(phone);
                            //会员等级
                            if (map.get("user_grade") != null) {
                                user_grade = String.valueOf(map.get("user_grade"));
                            }
                            sxssfRow.createCell(3).setCellValue(user_grade);
                            //性别
                            if (map.get("sex") != null) {
                                if("0".equals(String.valueOf(map.get("sex")))){
                                    sex = "男";
                                }else if("1".equals(String.valueOf(map.get("sex")))){
                                    sex = "女";
                                }else{
                                    sex = "其他";
                                }
                            }
                            sxssfRow.createCell(4).setCellValue(sex);
                            //生日
                            if (map.get("birthday") != null) {
                                birthday = String.valueOf(map.get("birthday"));
                            }
                            sxssfRow.createCell(5).setCellValue(birthday);
                            //开户机构
                            if (map.get("ouname") != null) {
                                ouname = String.valueOf(map.get("ouname"));
                            }
                            sxssfRow.createCell(6).setCellValue(ouname);
                            //注册时间
                            if (map.get("create_time") != null) {
                                create_time = String.valueOf(map.get("create_time"));
                            }
                            sxssfRow.createCell(7).setCellValue(create_time);
                        }
                        returnInfo.clear();
                    }
                }
                // 第七步，将文件输出到客户端浏览器
                try {
                    sxssfWorkbook.write(outer);
                    outer.flush();
                    outer.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("------导出完毕-------");
           return null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Map checkExcel(HttpServletRequest request) {
        Map<String, Object> hashMap = new HashMap<>();
        if(StringUtils.isNotBlank(request.getParameter("id"))){
            hashMap.put("id",request.getParameter("id"));
        }
        if(StringUtils.isNotBlank(request.getParameter("userId"))){
            hashMap.put("userId",request.getParameter("userId"));
        }
        if(StringUtils.isNotBlank(request.getParameter("orderNo"))){
            hashMap.put("orderNo",request.getParameter("orderNo"));
        }
        if(StringUtils.isNotBlank(request.getParameter("type"))){
            hashMap.put("type",request.getParameter("type"));
        }
        if(StringUtils.isNotBlank(request.getParameter("deptNo"))){
            hashMap.put("deptNo",request.getParameter("deptNo"));
        }
        if(StringUtils.isNotBlank(request.getParameter("cardNo"))){
            hashMap.put("cardNo",request.getParameter("cardNo"));
        }
        if(StringUtils.isNotBlank(request.getParameter("userName"))){
            hashMap.put("userName",request.getParameter("userName"));
        }
        if(StringUtils.isNotBlank(request.getParameter("phone"))){
            hashMap.put("phone",request.getParameter("phone"));
        }
        if(StringUtils.isNotBlank(request.getParameter("shiftNo"))){
            hashMap.put("shiftNo",request.getParameter("shiftNo"));
        }
        if(StringUtils.isNotBlank(request.getParameter("tradeStartTime"))){
            hashMap.put("tradeStartTime",request.getParameter("tradeStartTime"));
        }
        if(StringUtils.isNotBlank(request.getParameter("tradeEndTime"))){
            hashMap.put("tradeEndTime",request.getParameter("tradeEndTime"));
        }
        return null;
    }
}
