package org.forfun.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.forfun.constant.ResponseConstant;
import org.forfun.exceptions.AnimalException;
import org.springframework.core.convert.converter.Converter;

import java.io.Serializable;
import java.util.function.Consumer;
import java.util.function.Supplier;


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

    public static DefaultResponse getExceptionDefaultResponse(AnimalException e) {
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setCode(e.getCode());
        defaultResponse.setMsg(e.getMsgDes());
        return defaultResponse;
    }

    public static <T> DefaultResponse<T> wrapperResponse(Supplier<T> function) {
        try {
            return new DefaultResponse<T>().successedDefaultResponse(function.get());
        } catch (AnimalException e) {
            return new DefaultResponse<>(
                    e.getCode() == null ? ResponseConstant.DEFAULT_FAILED_CODE : e.getCode(), e.getMsgDes());
        }
    }

    public static <T, P> DefaultResponse<T> wrapperResponse(Consumer<P> function, P param) {
        try {
            function.accept(param);
            return new DefaultResponse<T>().successedDefaultResponse();
        } catch (AnimalException e) {
            return new DefaultResponse<>(e.getCode(), e.getMsgDes());
        }
    }

    public DefaultResponse<T> failedDefaultResponse(String msg) {
        setCode(ResponseConstant.DEFAULT_FAILED_CODE);
        setMsg(msg);
        return this;
    }

    public DefaultResponse<T> failedDefaultResponse() {
        return failedDefaultResponse(ResponseConstant.DEFAULT_FAILED_MSG);
    }

    public DefaultResponse<T> successedDefaultResponse() {
        setCode(ResponseConstant.DEFAULT_SUCCESS_CODE);
        setMsg(ResponseConstant.DEFAULT_SUCCESS_MSG);
        return this;
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

    @Override
    public String toString() {
        try {
            String str =
                    "DefaultResponse{"
                            + "code='"
                            + code
                            + '\''
                            + ", msg='"
                            + msg
                            + '\''
                            + ", data="
                            + new ObjectMapper().writeValueAsString(data)
                            + '}';
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public <S> DefaultResponse<S> convertResponse(Converter<T, S> converter) {
        DefaultResponse<S> response = new DefaultResponse<>();
        response.setCode(this.code);
        response.setMsg(this.msg);
        if (this.data != null) {
            response.setData(converter.convert(this.data));
        }
        return response;
    }
}
