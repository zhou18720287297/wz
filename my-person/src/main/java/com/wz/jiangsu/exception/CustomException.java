package com.wz.jiangsu.exception;

import com.wz.jiangsu.enums.BaseEnum;
import com.wz.jiangsu.enums.BaseExceptionEnum;
import lombok.Data;

/**
 * @program: wz
 * @author: wangzhou
 * @create: 2023-12-04 10:42
 * @description:
 **/
@Data
public class CustomException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private String msg; //异常中的信息
    private int code = 1001; //业务状态码，规则：4位数，从1001开始递增
    private int status = 500; //http状态码，按照http协议规范，如：200,201,400等

    public CustomException(BaseEnum baseEnum) {
        super(baseEnum.getValue());
        this.msg = baseEnum.getValue();
        this.code = baseEnum.getCode();
    }

    public CustomException(BaseEnum baseEnum, Throwable e) {
        super(baseEnum.getValue(), e);
        this.msg = baseEnum.getValue();
        this.code = baseEnum.getCode();
    }

    public CustomException(BaseExceptionEnum errorEnum) {
        super(errorEnum.getValue());
        this.status = errorEnum.getStatus();
        this.msg = errorEnum.getValue();
        this.code = errorEnum.getCode();
    }

    public CustomException(BaseExceptionEnum errorEnum, Throwable e) {
        super(errorEnum.getValue(), e);
        this.status = errorEnum.getStatus();
        this.msg = errorEnum.getValue();
        this.code = errorEnum.getCode();
    }

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public CustomException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, int status) {
        super(msg);
        this.msg = msg;
        this.code = code;
        this.status = status;
    }

    public CustomException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

    public CustomException(String msg, int code, int status, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
        this.status = status;
    }
}
