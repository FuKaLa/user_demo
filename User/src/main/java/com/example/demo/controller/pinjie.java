package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.example.demo.entity.ProcessInstanceInputVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-09-17 12:58
 **/
public class pinjie {
    public static void main(String[] args) throws Exception{
        //获取token
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingwdgogwhmwevcrxt2");
        request.setAppsecret("-90PaVSx5bfKuSClI096eL221eMPlmDyOS-0rB2A2siU81aa0Eskx_EgmTF8i_IO");
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        System.out.println(response.getAccessToken());
        //创建审批流
        ProcessInstanceInputVO oapiProcessinstanceCreateRequest = new ProcessInstanceInputVO();
        oapiProcessinstanceCreateRequest.setOriginatorUserId("216110465039218508");
        // 审批流表单参数，设置各表单项值
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo1.setName("申请单号");
        vo1.setValue("216110465039218508");
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo2.setName("开票类型");
        vo2.setValue("已收款开票");
        formComponentValues.add(vo1);
        formComponentValues.add(vo2);
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo3.setName("行政组织");
        vo3.setValue("北京一部");
        formComponentValues.add(vo3);
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo5.setName("申请金额");
        vo5.setValue("申请金额");
        formComponentValues.add(vo5);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo6.setName("票据类型");
        vo6.setValue("票据类型");
        formComponentValues.add(vo6);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo7.setName("业务类型");
        vo7.setValue("业务类型");
        formComponentValues.add(vo7);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo8 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo8.setName("销售名称");
        vo8.setValue("销售名称");
        formComponentValues.add(vo8);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo9 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo9.setName("部门");
        vo9.setValue("部门");
        formComponentValues.add(vo9);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo10 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo10.setName("业绩归属");
        vo10.setValue("业绩归属");
        formComponentValues.add(vo10);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo11 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo11.setName("开票信息-公司名称");
        vo11.setValue("开票信息-公司名称");
        formComponentValues.add(vo11);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo12 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo12.setName("地址");
        vo12.setValue("地址");
        formComponentValues.add(vo12);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo13 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo13.setName("电话");
        vo13.setValue("电话");
        formComponentValues.add(vo13);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo14 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo14.setName("税号");
        vo14.setValue("税号");
        formComponentValues.add(vo14);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo15 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo15.setName("开户行名称");
        vo15.setValue("开户行名称");
        formComponentValues.add(vo15);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo16 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo16.setName("开户行账号");
        vo16.setValue("开户行账号");
        formComponentValues.add(vo16);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo17 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo17.setName("客户名称");
        vo17.setValue("客户名称");
        formComponentValues.add(vo17);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo18 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo18.setName("备注");
        vo18.setValue("备注");
        formComponentValues.add(vo18);

        // 附件
        OapiProcessinstanceCreateRequest.FormComponentValueVo attachmentComponent = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        JSONObject attachmentJson = new JSONObject();
        attachmentJson.put("fileId", "6433971140");
        attachmentJson.put("fileName", "2644.JPG");
        attachmentJson.put("fileType", "jpg");
        attachmentJson.put("fileSize", "333");

        JSONArray array = new JSONArray();
        array.add(attachmentJson);
        attachmentComponent.setValue(array.toJSONString());
        attachmentComponent.setName("附件");
        formComponentValues.add(attachmentComponent);
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo>  details = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        for(int i =0;i<1;i++){
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail1.setName("产品名称");
            detail1.setValue("产品名称");
            details.add(detail1);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail2.setName("信息服务费");
            detail2.setValue("产品名称");
            details.add(detail2);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail3.setName("信息服务费");
            detail3.setValue("产品名称");
            details.add(detail3);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail4.setName("接口调试费");
            detail4.setValue("接口调试费");
            details.add(detail4);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail5.setName("签订总金额");
            detail5.setValue("签订总金额");
            details.add(detail5);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail6.setName("已开票金额");
            detail6.setValue("已开票金额");
            details.add(detail6);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail7.setName("已回款金额");
            detail7.setValue("已回款金额");
            details.add(detail7);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail8 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail8.setName("本次申请金额");
            detail8.setValue("本次申请金额");
            details.add(detail8);
        }
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo4.setName("明细");
        vo4.setValue(JSON.toJSONString(Arrays.asList(details)));
        formComponentValues.add(vo4);
        startProcessInstance(oapiProcessinstanceCreateRequest,formComponentValues,response.getAccessToken());

    }

    public static void startProcessInstance(ProcessInstanceInputVO processInstance, List<com.dingtalk.api.request.OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues,String token){
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
            OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
            request.setFormComponentValues(formComponentValues);
            request.setProcessCode("PROC-A13A2F2E-336C-436E-B850-BCE90F850902");
            request.setOriginatorUserId(processInstance.getOriginatorUserId());
            request.setDeptId(117704771L);
//            request.setAgentId(277047622L);
//            request.setDeptId(processInstance.getDeptId());
            OapiProcessinstanceCreateResponse response = client.execute(request, token);
            System.out.println(response.getErrmsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
