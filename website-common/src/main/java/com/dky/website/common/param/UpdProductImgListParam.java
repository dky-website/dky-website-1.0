package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by wangpeng on 2017/4/20.
 */
public class UpdProductImgListParam extends BaseParameter {

    @NotNull(message = "ID不能为空")
    private Long id;

    private Long productId;

    @NotBlank(message = "图片路径不能为空")
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
