package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wangpeng on 2017/2/27.
 */
public class QueryProductImgParam extends WebPageParameter {


    /**
     * 状态: @see StatusEnum
     * ENABLE(0,"启用"),
     * DISABLED(1,"禁用"),
     */
    private Integer status;

    private Long productId;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
