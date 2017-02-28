package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wonpera on 2017/2/25.
 */
public class QueryFrontMenuParam extends WebPageParameter {

    /**
     * 状态 @see StatusEnum
     * ENABLE(0,"启用"),
     * DISABLED(1,"禁用"),
     */
    private Integer status;

    /**
     * 类型 @see ProductTypeEnmu
     * ABOUT_US("1","关于我们"),
     PRODUCT("2","产品"),
     SHOW("3","SHOW"),
     SERVICE("4","服务"),
     CONTACT("5","联络"),
     */
    private String type;


    /**
     * 上级菜单id
     */
    private Long parentId;


    /**
     * 显示分类 1:内容加图片型  2:show 3:投诉区显示型
     */
    private String classify;


    /**
     * 菜单名称
     */
    private String menuName;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
