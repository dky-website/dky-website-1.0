package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by wangpeng on 2017/4/20.
 */
public class AddProductImgListParam extends BaseParameter {

    private Long productId;

    @NotBlank(message = "图片路径不能为空")
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
