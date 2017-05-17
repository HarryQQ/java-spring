package com.zoivi.exception;

import com.zoivi.enums.ResultEnums;

/**
 * Created by Administrator on 2017/4/30 0030.
 * 自定义的异常类 注意继承的是RuntimeException 而不是Exception
 * 区别如下：
 * RuntimeException 会进行事务回滚
 * Exception 不会进行事务回滚
 */
public class UserException extends RuntimeException {
    private Integer code;

    public UserException(ResultEnums enums) {
        super(enums.getMsg());
        this.code = enums.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
