package com.imooc.util;

public class MessageUtil {

    public static Message succcess(Object obj){
        Message msg = new Message();
        msg.setCode(1);
        msg.setMsg("成功");
        msg.setData(obj);
        return msg;
    }

    public static Message successNoreturn(){
       return  succcess(null);
    }

    public static Message error(Integer code,String errmsg){
        Message msg = new Message();
        msg.setCode(code);
        msg.setMsg(errmsg);
        return msg;
    }
}
