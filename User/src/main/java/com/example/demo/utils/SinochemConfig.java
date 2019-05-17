package com.example.demo.utils;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
public class SinochemConfig {
    private static Configuration config = null;
    /**
     * 配置文件名称
     */
    private static String configfile = "conf/system.properties";

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

    static {
        try {
            config = new PropertiesConfiguration(configfile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
