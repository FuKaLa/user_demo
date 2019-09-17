package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
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
//        Long deptId = 3797L;
//        oapiProcessinstanceCreateRequest.setDeptId(deptId);
        oapiProcessinstanceCreateRequest.setOriginatorUserId("186525515620993190");
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
        startProcessInstance(oapiProcessinstanceCreateRequest,formComponentValues,response.getAccessToken());

    }

    public static void startProcessInstance(ProcessInstanceInputVO processInstance, List<com.dingtalk.api.request.OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues,String token){
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
            OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
            request.setFormComponentValues(formComponentValues);
            request.setProcessCode("PROC-A13A2F2E-336C-436E-B850-BCE90F850902");
            request.setOriginatorUserId(processInstance.getOriginatorUserId());
            request.setDeptId(34429455L);
//            request.setAgentId(277047622L);
//            request.setDeptId(processInstance.getDeptId());
            OapiProcessinstanceCreateResponse response = client.execute(request, token);
            System.out.println(response.getErrmsg());
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
    }
