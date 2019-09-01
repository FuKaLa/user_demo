package com.example.demo.controller;

/**
 * 对称加密
 * A服务调用B服务
 * 2019年7月1日10:50:03
 * coder:mc
 * 根据秘钥和固定salt加密
 * A服务调用B服务
 * A服务通过固定的秘钥对参数进行加密，生成byte数组传给B服务
 * B服务拿到参数后，通过固定salt和固定秘钥对参数进行解密
 * 解密就是加密的逆运算
 * machuang
 */
public class Encryption {
    public static void main(String[] args)  {
        /**
         * 对称加密
         */
        String content = "machuangchuang12345..."; //需要加密的字符
        String key = "abc"; //密钥

        byte[] result = encryption(content, key);

        System.out.println("1234加密后的值：" + new String(result));
        System.out.println("---------------");
        System.out.println("1234解密后的值：" +new String(decipher(new String(result), key)));
    }


    public static byte[] encryption(String content,String key){
        byte[] contentBytes = content.getBytes();
        byte[] keyBytes = key.getBytes();

        byte dkey = 0;
        for(byte b : keyBytes){
            dkey ^= b;
        }

        byte salt = 0;  //随机盐值
        byte[] result = new byte[contentBytes.length];
        for(int i = 0 ; i < contentBytes.length; i++){
            salt = (byte)(contentBytes[i] ^ dkey ^ salt);
            result[i] = salt;
        }
        return result;
    }

    public static byte[] decipher(String content,String key){
        byte[] contentBytes = content.getBytes();
        byte[] keyBytes = key.getBytes();

        byte dkey = 0;
        for(byte b : keyBytes){
            dkey ^= b;
        }

        byte salt = 0;  //随机盐值
        byte[] result = new byte[contentBytes.length];
        for(int i = contentBytes.length - 1 ; i >= 0 ; i--){
            if(i == 0){
                salt = 0;
            }else{
                salt = contentBytes[i - 1];
            }
            result[i] = (byte)(contentBytes[i] ^ dkey ^ salt);
        }
        return result;
    }
}
