package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.Product;
import com.dky.website.common.bean.ProductImg;

import java.util.List;


/**
 * 产品前端展示view
 * Created by wonpera on 2017/2/28.
 */
public class FrontProductView extends BaseParameter {

    /**
     * 主键
     */
    private Long id;

    /**
     * 产品类型
     * 详见产品类型的菜单表 去除掉精选(注：精选排序要排在首位)
     */
    private String type;


    private String typeName;


    /**
     * 季节  1:spring  2:summer  3:autumn  4:winter
     */
    private String season;


    /**
     * 季节名称
     */
    private String seasonName;


    /**
     * 图片地址
     */
    private String imgUrl;


    /**
     * 排序字段
     */
    private Long ordered;

    private List<ProductImg> imgList;

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

    public List<ProductImg> getImgList() {
        return imgList;
    }

    public void setImgList(List<ProductImg> imgList) {
        this.imgList = imgList;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public void setSeasonName(String seasonName) {
        this.seasonName = seasonName;
    }

    public FrontProductView toView(Product product){
        this.id = product.getId();
        this.type = product.getType();
        this.season = product.getSeason();
        this.imgUrl = product.getImgUrl();
        this.ordered = product.getOrdered();
        return this;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
