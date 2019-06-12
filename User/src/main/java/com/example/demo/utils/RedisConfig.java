package com.example.demo.utils;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RedisConfig {

    /**
     * redis配置key
     */

    private static org.apache.commons.configuration.Configuration config = null;
    /**
     * 配置文件名称
     */
    private static String configfile = "conf/redisConfig.properties";

    public static String getString(String key) {
        return config.getString(key);
    }

    public static int getInt(String key) {
        return config.getInt(key);
    }

    public static long getLong(String key) {
        return config.getLong(key);
    }

    public static boolean getBoolean(String key) {
        return config.getBoolean(key);
    }


    public static String[] getStringArray(String key) {
        return config.getStringArray(key);
    }

    public static void setPropertiesConfig(PropertiesConfiguration prop) {
        config = prop;
    }

    public static void main(String[] args) {
        String[] strArray = getStringArray(RedisConstant.REDIS_POOL);
        System.out.println(strArray[0] + strArray.length);
    }

    static {
        try {
            config = new PropertiesConfiguration(configfile);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
    }


}
