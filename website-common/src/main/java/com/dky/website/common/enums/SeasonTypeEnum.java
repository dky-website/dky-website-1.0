package com.dky.website.common.enums;

/**
 * Created by wangpeng on 2017/3/1.
 */
public enum  SeasonTypeEnum {
    PRODUCT_TYPE(1,"spring"),
    SHOW_TYPE(2,"summer"),
    ;


    private Integer code;

    private String message;

    SeasonTypeEnum(Integer code, String message) {
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
