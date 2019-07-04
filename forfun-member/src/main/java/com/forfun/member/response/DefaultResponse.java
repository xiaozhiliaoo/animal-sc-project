package com.forfun.member.response;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.convert.converter.Converter;

import java.io.Serializable;


public class DefaultResponse<T> implements Serializable {

    private String code;

    private String msg;

    private T data;

    public DefaultResponse() {
    }

    public DefaultResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static DefaultResponse getFailedDefaultResponse() {
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setCode(ResponseConstant.DEFAULT_FAILED_CODE);
        defaultResponse.setMsg(ResponseConstant.DEFAULT_FAILED_MSG);
        return defaultResponse;
    }

    public static DefaultResponse getSuccessdDefaultResponse() {
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setCode(ResponseConstant.DEFAULT_SUCCESS_CODE);
        defaultResponse.setMsg(ResponseConstant.DEFAULT_SUCCESS_MSG);
        return defaultResponse;
    }



    public DefaultResponse<T> successedDefaultResponse(T data) {
        setCode(ResponseConstant.DEFAULT_SUCCESS_CODE);
        setMsg(ResponseConstant.DEFAULT_SUCCESS_MSG);
        setData(data);
        return this;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

