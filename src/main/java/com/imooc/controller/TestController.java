package com.imooc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class TestController {

    @RequestMapping(value = "/hello3",method = RequestMethod.GET)
    public String say3(){
        return "index";
    }
}
