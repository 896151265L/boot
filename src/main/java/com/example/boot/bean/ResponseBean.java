package com.example.boot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created
 * author:  lqk
 * 2019/7/30 11:15
 */
@Data
public class ResponseBean implements Serializable {

    private static final long serialVersionUID = 1318186444070683468L;

    private String respCode;
    private String respResp;
    private Object date;


    /**
     *
     * @param respCode  响应码
     * @param respResp  响应Code
     */
    public ResponseBean(String respCode, String respResp) {
        this.respCode = respCode;
        this.respResp = respResp;
    }

    /**
     *
     * @param respCode  响应码
     * @param respResp  响应Code
     * @param date      响应数据
     */
    public ResponseBean(String respCode, String respResp, Object date) {
        this.respCode = respCode;
        this.respResp = respResp;
        this.date = date;
    }


}
