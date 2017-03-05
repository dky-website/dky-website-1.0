package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.FrontMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonpera on 2017/3/5.
 */
public class ProductTypeView extends BaseParameter {

    /**
     * id
     */
    private String id;


    /**
     * 类型名称
     */
    private String typeName;


    /**
     * 类型英文名称
     */
    private String typeEnName;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeEnName() {
        return typeEnName;
    }

    public void setTypeEnName(String typeEnName) {
        this.typeEnName = typeEnName;
    }

    public ProductTypeView toView(FrontMenu frontMenu){
        if(frontMenu == null){
            return null;
        }
        ProductTypeView productTypeView = new ProductTypeView();
        productTypeView.setId(String.valueOf(frontMenu.getId()));
        productTypeView.setTypeName(frontMenu.getMenuName());
        productTypeView.setTypeEnName( frontMenu.getMenuEnName());
        return productTypeView;
    }

    public List<ProductTypeView> toViewList(List<FrontMenu> list){
        if(list == null || list.size() == 0){
            return null;
        }
        List<ProductTypeView> viewList = new ArrayList<>(list.size());
        for(FrontMenu menu : list){
            viewList.add(toView(menu));
        }
        return viewList;
    }
}
