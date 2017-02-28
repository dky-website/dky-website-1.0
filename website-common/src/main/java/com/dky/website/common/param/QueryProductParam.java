package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wangpeng on 2017/2/27.
 */
public class QueryProductParam extends WebPageParameter {


    /**
     * 状态: @see StatusEnum
     * ENABLE(0,"启用"),
     * DISABLED(1,"禁用"),
     */
    private Integer status;


    /**
     * 产品类型
     * 详见产品类型的菜单表 去除掉精选(注：精选排序要排在首位)
     */
    private String type;


    /**
     * 季节  1:spring  2:summer  3:autumn  4:winter
     */
    private String season;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
