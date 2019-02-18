package com.imooc.handle;

import com.imooc.exception.GirlException;
import com.imooc.util.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class ExceptionHandler {


    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Message handle(Exception e){
        if(e instanceof GirlException){
            GirlException e1 = (GirlException) e;
            return  MessageUtil.error(e1.getCode(),e1.getMessage());
        }else{
            return MessageUtil.error(-1,"未知错误");
        }
    }
}
