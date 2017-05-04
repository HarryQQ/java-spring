package com.zoivi.domain;

import org.omg.CORBA.Object;

/**
 * http请求返回的对象最外层
 * Created by Administrator on 2017/4/30 0030.
 */
public class Result <T>{
    private Integer code; // 错误码
    private String msg; // 提示信息
    private T data; // 具体返回数据 原来想用Object 这里用泛型

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
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


