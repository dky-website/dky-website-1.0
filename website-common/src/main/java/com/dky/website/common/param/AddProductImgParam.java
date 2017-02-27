package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;


/**
 * Created by wangpeng on 2017/2/27.
 */
public class AddProductImgParam extends BaseParameter {


    private Long productId;

    private String imgUrl;

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
