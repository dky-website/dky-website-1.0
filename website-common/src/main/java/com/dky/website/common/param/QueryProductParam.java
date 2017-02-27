package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wangpeng on 2017/2/27.
 */
public class QueryProductParam extends WebPageParameter {

    private Integer status;

    private String type;

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
