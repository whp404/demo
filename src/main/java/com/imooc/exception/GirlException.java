package com.imooc.exception;

import com.imooc.enums.ResultEnum;

public class GirlException extends  RuntimeException {

    private  Integer code;

    public GirlException(ResultEnum e){
        super(e.getMessage());
        this.code = e.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
