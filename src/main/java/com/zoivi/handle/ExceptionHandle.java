package com.zoivi.handle;

import com.zoivi.domain.Result;
import com.zoivi.exception.GirlException;
import com.zoivi.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 捕获异常类 这里捕获的是controller抛出来的异常，这个是最后面处理的
 * Created by Administrator on 2017/4/30 0030.
 */
@ControllerAdvice
public class ExceptionHandle {
    // 引入记录日志对象
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GirlException) { // 如果捕获的是自定义的exception
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        } else {
            // 当系统自身的错误，捕获后无法识别，如空指针之类的异常，所以这里在日志中记录下异常信息
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1, "服务器异常");
        }
    }
}
