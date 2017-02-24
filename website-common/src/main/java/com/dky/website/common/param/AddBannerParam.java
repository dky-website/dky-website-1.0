package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;

import java.util.Date;

/**
 * Created by wonpera on 2017/2/24.
 */
public class AddBannerParam extends BaseParameter {

    private String bannerName;

    private String path;

    private Integer status;

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
