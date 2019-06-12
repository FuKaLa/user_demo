package com.example.demo.utils;


import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.Properties;
public class PropertiesUtil implements Serializable {
    private static final long serialVersionUID = 6673769404904969188L;
    public static Properties props = null;
    static{
//        原来的debug模式是通过system.propertiy开启的。这个以后应该是Maven控制的
        Resource moderes = new ClassPathResource("/conf/redisConfig.properties");
        EncodedResource resmoderes = new EncodedResource(moderes,"UTF-8");
        try {
            Properties modeprop = PropertiesLoaderUtils.loadProperties(resmoderes);
            String filename="/conf/prop.properties";
            if("true".equals(modeprop.get("debug"))){
                filename="/conf/debug.prop.properties";
            }
            Resource resource = new ClassPathResource(filename);
            EncodedResource encRes = new EncodedResource(resource,"UTF-8");
            props = PropertiesLoaderUtils.loadProperties(encRes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
//        String url=PropertiesUtil.props.getProperty("cardUrl");
//        System.out.println(url);
    }
}