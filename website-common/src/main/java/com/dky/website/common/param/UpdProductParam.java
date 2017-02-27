package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;


/**
 * Created by wangpeng on 2017/2/27.
 */
public class UpdProductParam extends BaseParameter {

    private Long id;

    private String type;

    private String season;

    private String imgUrl;

    private Long ordered;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Long getOrdered() {
        return ordered;
    }

    public void setOrdered(Long ordered) {
        this.ordered = ordered;
    }
}
