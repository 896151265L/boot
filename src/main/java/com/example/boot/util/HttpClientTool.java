package com.example.boot.util;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * Created
 * author:  lqk
 * 2019/8/9 15:29
 */
public class HttpClientTool {



    private static final int CONNECT_TIME_OUT = 10000;
    private static final int SOCKET_TIME_OUT = 10000;
    private static final int CONNECTION_REQUEST_TIMEOUT = 10000;

    /**
     * 超时时间
     * @return
     */
    public static RequestConfig getDefaultTimeoutConfig() {
        return RequestConfig.custom()
                .setSocketTimeout(SOCKET_TIME_OUT)
                .setConnectTimeout(CONNECT_TIME_OUT)
                .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT).build();
    }

    /**
     * Http Post请求 ，参数类型：Object
     * @param url
     * @param config
     * @param headerMap
     * @param params
     * @return
     * @throws Exception
     */
    public static String sendJsonPost(String url, RequestConfig config, Map<String, Object> headerMap, Object params) throws Exception {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault(); //创建Httpclient对象
            HttpPost httpPost = new HttpPost(url);    //创建http Post请求
            //设置请求头内容
            httpPost.setHeader("HTTP Method", "POST");                                  //请求方式
            httpPost.setHeader("Connection", "Keep-Alive");                             //指定连接保持时间
            httpPost.setHeader("Content-Type", "application/json;charset=utf-8");       //请求参数类型
            if (!StringUtils.isEmpty(headerMap)) {
                for (Map.Entry<String, Object> entry : headerMap.entrySet()) {
                    httpPost.setHeader(entry.getKey(), entry.getValue().toString());
                }
            }
            //设置请求参数
            StringEntity entity = new StringEntity(JSON.toJSONString(params), Charset.forName("utf-8"));
            httpPost.setEntity(entity);
            httpPost.setConfig(StringUtils.isEmpty(config) ? getDefaultTimeoutConfig() : config);
            //执行http请求
            response = httpClient.execute(httpPost);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                //解析响应数据
                result = EntityUtils.toString(response.getEntity(), "utf-8");
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            response.close();
            httpClient.close();
        }
        return result;
    }

    /**
     * Http get请求 参数拼接在url后边
     * @param url
     * @return
     * @throws Exception
     */
    public static String sendGet(String url, RequestConfig config) throws Exception{
        //创建Httpclient对象
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        String result = null;
        try {
            httpclient = HttpClients.createDefault();
            //创建http Get请求
            HttpGet httpGet = new HttpGet(url);
            if (StringUtils.isEmpty(config)) {
                httpGet.setConfig(getDefaultTimeoutConfig());
            } else {
                httpGet.setConfig(config);
            }
            //执行http请求
            response = httpclient.execute(httpGet);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                //解析响应数据
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
            }
        } finally {
            response.close();
            httpclient.close();
        }
        return result;
    }



}
