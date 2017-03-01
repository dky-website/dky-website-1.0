package com.dky.website.common.enums;

/**
 * Created by wangpeng on 2017/3/1.
 */
public enum  SeasonEnum {
    SPRING("1","spring"),
    SUMMER("2","summer"),
    AUTUMN("3","autumn"),
    WINTER("4","winter"),
    ;


    private String code;

    private String message;

    SeasonEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String getEnumMessageByCode(String code){
        for(SeasonEnum seasonEnum : values()){
            if(seasonEnum.getCode().equals(code)){
                return seasonEnum.getMessage();
            }
        }
        return null;
    }
}
