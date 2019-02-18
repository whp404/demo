package com.imooc.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"上小学"),
    MIDDLE_SCHOOL(101,"上初中");


    private  Integer Code;

    private String message;

    ResultEnum(Integer code, String message) {
        Code = code;
        this.message = message;
    }

    public Integer getCode() {
        return Code;
    }

    public void setCode(Integer code) {
        Code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
