package com.zoivi.enums;

/**
 * Created by Administrator on 2017/4/30 0030.
 * 错误码的枚举
 * 加构造方法
 * 不需要set方法
 */
public enum ResultEnums {
    UMKONW_ERROR(-1, "系统错误"),
    SUCCESS(200, "成功"),
    USER_NO_FOUND(305, "用户不存在"),
    PASSWORD_WRONG(306, "密码错误"),
    PRIMARY_SCHOOL(100, "上小学"),
    MIDDLE_SCHOOL(101, "上中学");

    private Integer code;
    private String msg;

    ResultEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
