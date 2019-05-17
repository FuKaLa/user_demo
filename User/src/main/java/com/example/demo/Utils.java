package com.example.demo;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Utils {
    public static String send(String url, Map<String,String> map) throws Exception {
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));

        System.out.println("请求地址：" + url);
        System.out.println("请求参数：" + nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        httpPost.setHeader("x-application","KAPOS");
        httpPost.setHeader("x-service","/order/query");
        httpPost.setHeader("x-token",".3e2_UajfP5HyyRWTKMk4xH9su3Vw0aRcF-IAslkpRwOsSNhbysEBeYU0iKKNtl8ZBS8I8Cp1TOg3d98ijcv_DgDllK6C_b_c0-7wrSNmre4hjBKNlOtTRDfN99zX3qVel7pCAMxpyZMq-OLkA_3QDaCWx5GEIezFagV-Kn-g_YA=");
        httpPost.setHeader("appKey","test_kaorderapi");
        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        body = EntityUtils.toString(entity);
        //释放链接
        response.close();
        return body;
    }

    public static String doPostJson(String url, String parameterData) throws Exception {



        // System.setProperty("http.proxyHost", "proxy1.bj.petrochina");
        // System.setProperty("http.proxyPort", "8080");

        URL localURL = new URL(url);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept", "application/json");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=utf-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
        httpURLConnection.setRequestProperty("appKey","test_kaorderdata");
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        try {

            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream, "utf-8");

            outputStreamWriter.write(parameterData);
            outputStreamWriter.flush();

            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }

            if (reader != null) {
                reader.close();
            }

            if (inputStreamReader != null) {
                inputStreamReader.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }
        return resultBuffer.toString();
    }

}
