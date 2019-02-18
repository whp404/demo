package com.imooc.controller;

import com.imooc.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${cupSize}")
    private  String cupSize;

    @Value("${age}")
    private Integer age;

    @Value("${content}")
    private String content;


    @Autowired
    private GirlProperties girlProperties;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String say(){
        return "hello spring boot";
    }


    @RequestMapping(value = "/hello1",method = RequestMethod.GET)
    public String say1(){
        return content;
    }

    @RequestMapping(value = "/hello2",method = RequestMethod.GET)
    public String say2(){
        return girlProperties.getHeight();
    }


}
