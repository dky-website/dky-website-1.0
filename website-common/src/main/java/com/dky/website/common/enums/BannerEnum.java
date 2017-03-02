package com.dky.website.common.enums;

/**
 * Created by wangpeng on 2017/2/21.
 */
public enum BannerEnum {

    INDEX(1,"首页"),
    SHOW(2,"show"),
    ;

    private Integer code;

    private String message;

    BannerEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
