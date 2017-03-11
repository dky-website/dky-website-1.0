package com.dky.website.common.bean;

import com.dky.website.common.base.BaseParameter;

/**
 * Created by wonpera on 2017/3/11.
 */
public class QuerySeasonWithProduct extends BaseParameter {

    private String type;

    private Long season;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getSeason() {
        return season;
    }

    public void setSeason(Long season) {
        this.season = season;
    }
}
