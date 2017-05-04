package com.zoivi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by Administrator on 2017/4/30 0030.
 */
@Aspect
@Component
public class HttpAspect {
    /**
     * 使用logger替换掉自已的手动输出
     * Logger 注意要导入的是org.slf4j.Logger这个，是spring自带的log框架
     */
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    /**
     * 第一种写法
     */

    // 执行方法之前调用 .后面加方法，用*表示全部方法都拦截
//    @Before("execution(public * com.zoivi.controller.GirlController.*(..))") // 两个点表示不管什么参数都会被拦截
//    public void doBefore() {
//        System.out.println("开始执行前");
//    }

//    @After("execution(public * com.zoivi.controller.GirlController.*(..))")
//    public void doAfter() {
//        System.out.println("结束执行后");
//    }

    /**
     * 第二种写法
     */
    @Pointcut("execution(public * com.zoivi.controller.GirlController.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("开始执行前");
        // 记录请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // url
        logger.info("url={}", request.getRequestURL());
        // method
        logger.info("method={}", request.getMethod());
        // ip
        logger.info("ip={}", request.getRemoteAddr());
        // 类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // 参数
        logger.info("args={}", joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("结束执行后");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}
