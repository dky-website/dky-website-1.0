package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;

import java.util.List;

/**
 * 首页菜单
 * Created by wonpera on 2017/2/28.
 */
public class FrontMenuView extends BaseParameter {

    /**
     * 主键
     */
    private Long id;


    /**
     * 产品类型 1:关于我们  2:产品  3:SHOW  4:服务  5:联络
     */
    private String type;


    /**
     * 菜单名称
     */
    private String menuName;


    /**
     * 分类  1:内容加图片型  2:show   3:投诉区显示型
     */
    private String classify;


    /**
     * 图片地址
     */
    private String imgUrl;


    /**
     * 排序id
     */
    private Integer ordered;


    /**
     * 内容
     */
    private String content;

    /**
     * 子菜单
     */
    private List<FrontMenuView> children;

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

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<FrontMenuView> getChildren() {
        return children;
    }

    public void setChildren(List<FrontMenuView> children) {
        this.children = children;
    }
}
