package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wonpera on 2017/2/24.
 */
public class QueryBannerParam extends WebPageParameter {


    /**
     * 状态: @see StatusEnum
     * ENABLE(0,"启用"),
     * DISABLED(1,"禁用"),
     */
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
