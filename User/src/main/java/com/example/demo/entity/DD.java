package com.example.demo.entity;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCspaceGrantCustomSpaceRequest;
import com.dingtalk.api.response.OapiCspaceGrantCustomSpaceResponse;

/**
 * @program: demo
 * @description:
 * @author: MC
 * @create: 2019-09-19 16:46
 **/
public class DD {
    public static void main(String[] args) throws Exception{
        DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/cspace/grant_custom_space");
        OapiCspaceGrantCustomSpaceRequest request = new OapiCspaceGrantCustomSpaceRequest();
        request.setType("add");
        request.setUserid("216110465039218508");
        request.setPath("/");
        request.setDuration(10000L);
        request.setHttpMethod("GET");
        OapiCspaceGrantCustomSpaceResponse response = client.execute(request,"7fbd43c1d71a35a097b276e33adb0cb9");
    }
}
