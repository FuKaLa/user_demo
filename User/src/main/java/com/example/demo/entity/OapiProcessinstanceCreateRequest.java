package com.example.demo.entity;

/**
 * @Classname OapiProcessinstanceCreateRequest
 * @Description: TODO
 * @Auther: liuzhichao
 * @Date: 2019/7/11 11:22
 * @Version: 1.0
 */
public class OapiProcessinstanceCreateRequest extends com.dingtalk.api.request.OapiProcessinstanceCreateRequest {
    private String topResponseType = "dingtalk";
    private String topHttpMethod = "POST";

    public String getTopResponseType() {
        return topResponseType;
    }

    public void setTopResponseType(String topResponseType) {
        this.topResponseType = topResponseType;
    }

    public String getTopHttpMethod() {
        return topHttpMethod;
    }

    public void setTopHttpMethod(String topHttpMethod) {
        this.topHttpMethod = topHttpMethod;
    }
}
