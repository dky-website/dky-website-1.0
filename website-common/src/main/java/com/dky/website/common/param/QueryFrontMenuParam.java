package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wonpera on 2017/2/25.
 */
public class QueryFrontMenuParam extends WebPageParameter {

    private Integer status;

    private String type;

    private Long parentId;

    private String classify;

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
