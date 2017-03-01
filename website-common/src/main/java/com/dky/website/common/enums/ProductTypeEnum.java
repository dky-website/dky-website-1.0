package com.dky.website.common.enums;

/**
 * Created by wonpera on 2017/2/27.
 */
public enum ProductTypeEnum {

    ABOUT_US("1","关于我们"),
    PRODUCT("2","产品"),
    SHOW("3","SHOW"),
    SERVICE("4","服务"),
    CONTACT("5","联络"),
    ;

    private String code;

    private String message;

    ProductTypeEnum(String code, String message) {
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
        for(ProductTypeEnum productTypeEnum : values()){
            if(productTypeEnum.getCode().equals(code)){
                return productTypeEnum.getMessage();
            }
        }
        return null;
    }
}
