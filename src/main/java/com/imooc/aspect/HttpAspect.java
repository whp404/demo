package com.imooc.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class HttpAspect {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.imooc.controller.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void beforeInvoke(JoinPoint joinPoint) {
        System.out.println("begin");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info("url={}",request.getRequestURL());
        logger.info("method={}",joinPoint.getSignature().getName());
        logger.info("args={}",joinPoint.getArgs());



    }


    @After("log()")
    public void afterInvoke() {
        System.out.println("end");
    }


    @AfterReturning(value = "log()",returning = "obj")
    public void afterInvoke(Object obj) {
        logger.info("reponse={}",obj.toString());
    }

}
