package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;


/**
 * Created by wangpeng on 2017/2/27.
 */
public class UpdProductImgParam extends BaseParameter {

    private Long id;

    private Long productId;

    private String imgUrl;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
