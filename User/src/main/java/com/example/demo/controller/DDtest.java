package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceGetRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceGetResponse;
import com.example.demo.entity.ProcessInstanceInputVO;
import com.taobao.api.ApiException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: demo
 * @description: ]
 * @author: MC
 * @create: 2019-09-23 10:54
 **/
public class DDtest {

    public  static String orderApproveControllerService() throws Exception {
        //获取token
        String accessToken = getAccesstoken("dingwdgogwhmwevcrxt2", "-90PaVSx5bfKuSClI096eL221eMPlmDyOS-0rB2A2siU81aa0Eskx_EgmTF8i_IO");
        // 审批流表单参数，设置各表单项值
        ProcessInstanceInputVO oapiProcessinstanceCreateRequest = new ProcessInstanceInputVO();
        oapiProcessinstanceCreateRequest.setOriginatorUserId("216110465039218508");
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo1.setName("申请单号");
        vo1.setValue("orderVo.getOrderCode()");
        formComponentValues.add(vo1);
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo2.setName("开票类型");
        vo2.setValue("已收款开票");
        formComponentValues.add(vo2);
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo3.setName("行政组织");
        vo3.setValue("北京一部");
        formComponentValues.add(vo3);
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo5.setName("申请金额");
//        vo5.setValue(String.valueOf(orderVo.getTicketAmout()));
        vo5.setValue("1");
        formComponentValues.add(vo5);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo6.setName("票据类型");
        vo6.setValue("票据类型");
        formComponentValues.add(vo6);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo7.setName("业务类型");
        vo7.setValue("非项目类");
        formComponentValues.add(vo7);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo8 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo8.setName("销售名称");
        vo8.setValue("orderVo.getMarketName()");
        formComponentValues.add(vo8);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo9 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo9.setName("部门");
        vo9.setValue("orderVo.getMarketDeptName()");
        formComponentValues.add(vo9);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo10 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();

        vo10.setName("业绩归属");
        vo10.setValue("businessDistributeVo.getBusinessComy()");
        formComponentValues.add(vo10);
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo11 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo11.setName("开票信息-公司名称");
        vo11.setValue("orderVo.getMarketDeptName()");
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
        vo15.setValue("receivablesVo.getBankName()");
        formComponentValues.add(vo15);


        OapiProcessinstanceCreateRequest.FormComponentValueVo vo16 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo16.setName("开户行账号");
        vo16.setValue("receivablesVo.getBankNo())");
        formComponentValues.add(vo16);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo17 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo17.setName("客户名称");
        vo17.setValue("receivablesVo.getMarketName()");
        formComponentValues.add(vo17);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo18 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo18.setName("备注");
        vo18.setValue("receivablesVo.getRemark()");
        formComponentValues.add(vo18);

        //拼装明细接口
        List<OapiProcessinstanceCreateRequest.FormComponentValueVo> details = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
        for (int i = 0; i < 1; i++) {
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail1.setName("产品名称");
            detail1.setValue("detailVo.getProductName()");
            details.add(detail1);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail2.setName("信息服务费");
            detail2.setValue(String.valueOf("detailVo.getServiceFee())"));
            details.add(detail2);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail4.setName("接口调试费");
            detail4.setValue(String.valueOf("detailVo.getDebugFee()"));
            details.add(detail4);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail5.setName("签订总金额");
            detail5.setValue(String.valueOf("detailVo.getContractAmount()"));
            details.add(detail5);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail6.setName("已开票金额");
            detail6.setValue(String.valueOf("detailVo.getTicketAmount()"));
            details.add(detail6);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail7.setName("已回款金额");
            detail7.setValue(String.valueOf("detailVo.getReceiveAmount()"));
            details.add(detail7);
            OapiProcessinstanceCreateRequest.FormComponentValueVo detail8 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
            detail8.setName("本次申请金额");
            detail8.setValue(String.valueOf("detailVo.getSingleInvocieAmount()"));
            details.add(detail8);
        }
        OapiProcessinstanceCreateRequest.FormComponentValueVo vo4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo4.setName("明细");
        vo4.setValue(JSON.toJSONString(Arrays.asList(details)));
        formComponentValues.add(vo4);

        OapiProcessinstanceCreateRequest.FormComponentValueVo vo19 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
        vo19.setName("图片");
        /**
         * [
         *        {"name":"eimp-portal-app(1).rar","url":"http://s3-dev.sinoiov.com/api/urlDownload/eimp/eimp-crm_5cb6ab41-945a-4c02-bba5-e83c717ad15e.rar?cdn=0"},
         *        {"name":"11111.jpg","url":"http://s3-dev.sinoiov.com/api/urlDownload/eimp/eimp-crm_869abb24-450d-403b-9bb1-32094aa17da1.jpg?cdn=0"}
         * ]
         */

        ArrayList<Object> urlsAddress = new ArrayList<>();
        urlsAddress.add("http://s3-dev.sinoiov.com/api/urlDownload/eimp/eimp-crm_869abb24-450d-403b-9bb1-32094aa17da1.jpg?cdn=0");

        vo19.setValue(JSON.toJSONString(urlsAddress));
        formComponentValues.add(vo19);
       return startProcessInstance(oapiProcessinstanceCreateRequest, formComponentValues, accessToken);

    }

    public static String startProcessInstance(ProcessInstanceInputVO processInstance, List<com.dingtalk.api.request.OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues, String token) {
        OapiProcessinstanceCreateResponse response = null;
        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/create");
            OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
            request.setFormComponentValues(formComponentValues);
            request.setProcessCode("PROC-A13A2F2E-336C-436E-B850-BCE90F850902");
            request.setOriginatorUserId(processInstance.getOriginatorUserId());
            request.setDeptId(117704771L);
            response = client.execute(request, token);
            System.out.println(response.getProcessInstanceId());
            return response.getProcessInstanceId();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @param
     * @author mc
     * @description 封装pdf存在的json
     * @return
     * @date 2019/9/23
     */


    public static String getAccesstoken(String appid, String appSecret) throws Exception {
        String URL_GET_TOKKEN = "https://oapi.dingtalk.com/gettoken";

        try {
            DefaultDingTalkClient client = new DefaultDingTalkClient(URL_GET_TOKKEN);
            OapiGettokenRequest request = new OapiGettokenRequest();

            request.setAppkey(appid);
            request.setAppsecret(appSecret);
            request.setHttpMethod("GET");
            OapiGettokenResponse response = client.execute(request);
            String accessToken = response.getAccessToken();
            System.out.println("accessToken-"+accessToken);
            return accessToken;
        } catch (ApiException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws Exception {
        String s = orderApproveControllerService();
        getTalk(s);
    }


    public static void getTalk(String s) throws Exception{
        String accessToken = getAccesstoken("dingwdgogwhmwevcrxt2", "-90PaVSx5bfKuSClI096eL221eMPlmDyOS-0rB2A2siU81aa0Eskx_EgmTF8i_IO");
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/topapi/processinstance/get");
        OapiProcessinstanceGetRequest request = new OapiProcessinstanceGetRequest();
        request.setProcessInstanceId(s);
        OapiProcessinstanceGetResponse response = client.execute(request,accessToken);
        OapiProcessinstanceGetResponse.ProcessInstanceTopVo instance = response.getProcessInstance();
        System.out.println(instance);

    }
}