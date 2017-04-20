package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wangpeng on 2017/4/20.
 */
public class QueryProductImgListParam extends WebPageParameter {

    private Long id;

    private Long productId;

    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
