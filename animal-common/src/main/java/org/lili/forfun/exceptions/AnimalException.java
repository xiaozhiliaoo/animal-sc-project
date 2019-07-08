package org.lili.forfun.exceptions;


public class AnimalException extends RuntimeException {

    private String code; //异常对应的返回码
    private String msgDes; //异常对应的描述信息

    public AnimalException() {
        super();
    }

    public AnimalException(String message) {
        super(message);
        msgDes = message;
    }

    public AnimalException(String code, String msgDes) {
        super(msgDes);
        this.code = code;
        this.msgDes = msgDes;
    }

    public String getCode() {
        return code;
    }

    public String getMsgDes() {
        return msgDes;
    }
}
