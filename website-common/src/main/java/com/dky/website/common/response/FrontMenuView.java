package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.FrontMenu;

import java.util.ArrayList;
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

    /**
     * 父菜单Id
     */
    private Long parentId;

    private boolean hasChildren = false;

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

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public FrontMenuView toView(FrontMenu frontMenu){
        if (frontMenu == null) {
            return null;
        }
        this.id  = frontMenu.getId();
        this.type = frontMenu.getType();
        this.classify = frontMenu.getClassify();
        this.menuName = frontMenu.getMenuName();
        this.ordered = frontMenu.getOrdered();
        this.content = frontMenu.getContent();
        this.imgUrl = frontMenu.getImgUrl();
        this.parentId = frontMenu.getParentId();
        return this;
    }

    public List<FrontMenuView> toViewList(List<FrontMenu> list){
        if (list == null || list.size() == 0) {
            return null;
        }
        List<FrontMenuView> viewList = new ArrayList<>(list.size());
        for (FrontMenu menu : list) {
            viewList.add(new FrontMenuView().toView(menu));
        }
        return viewList;
    }
}
