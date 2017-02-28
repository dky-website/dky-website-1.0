package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.business.mapper.FrontMenuMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.FrontMenu;
import com.dky.website.common.enums.ProductTypeEnmu;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddFrountMenuParam;
import com.dky.website.common.param.QueryFrontMenuParam;
import com.dky.website.common.param.UpdFrontMenuParam;
import com.dky.website.common.response.FrontMenuView;
import com.dky.website.common.response.ReturnT;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wonpera on 2017/2/25.
 */
@Service
public class FrontMenuServiceImpl implements FrontMenuService {

    @Autowired
    private FrontMenuMapper frontMenuMapper;

    @Override
    public PageHelper.Page<FrontMenu> queryFMenuPage(QueryFrontMenuParam param) {
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        FrontMenu frontMenu = new FrontMenu();
        BeanUtils.copyProperties(param,frontMenu);
        frontMenu.setStatus(StatusEnum.ENABLE.getCode());
        frontMenu.putExtendedParameterValue("sidx","type,ordered");
        frontMenu.putExtendedParameterValue("sord","asc");
        frontMenuMapper.query(frontMenu);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT<List<FrontMenu>> queryFMenuList(QueryFrontMenuParam param) {
        FrontMenu frontMenu = new FrontMenu();
        BeanUtils.copyProperties(param,frontMenu);
        frontMenu.setStatus(StatusEnum.ENABLE.getCode());
        List<FrontMenu> list = frontMenuMapper.query(frontMenu);
        return new ReturnT<>().sucessData(list);
    }

    @Override
    public ReturnT addFMenu(AddFrountMenuParam param) {
        FrontMenu frontMenu = new FrontMenu();
        BeanUtils.copyProperties(param,frontMenu);
        frontMenu.setStatus(StatusEnum.ENABLE.getCode());
        frontMenu.setCreateTime(new Date());
        frontMenuMapper.insertSelective(frontMenu);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updateFMenu(UpdFrontMenuParam param) {
        FrontMenu frontMenu = new FrontMenu();
        BeanUtils.copyProperties(param,frontMenu);
        frontMenu.setUpdateTime(new Date());
        frontMenuMapper.updateByPrimaryKeySelective(frontMenu);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT deleteFMenu(Long id) {
        FrontMenu frontMenu = new FrontMenu();
        frontMenu.setId(id);
        frontMenu.setStatus(StatusEnum.DISABLED.getCode());
        frontMenuMapper.updateByPrimaryKeySelective(frontMenu);
        return  new ReturnT().successDefault();
    }

    @Override
    public ReturnT<FrontMenu> getFMenuById(Long id) {
        return new ReturnT<>().sucessData(frontMenuMapper.selectByPrimaryKey(id));
    }


    /**
     * 获取产品下拉，排除精选
     * @return
     */
    @Override
    public List<FrontMenu> getProductTypeWithOutChoice() {
        FrontMenu frontMenu = new FrontMenu();
        frontMenu.setStatus(StatusEnum.ENABLE.getCode());
        frontMenu.setType(ProductTypeEnmu.PRODUCT.getCode());
        frontMenu.putExtendedParameterValue("sidx","ordered");
        frontMenu.putExtendedParameterValue("sord","asc");
        List<FrontMenu> list = frontMenuMapper.query(frontMenu);
        if(list.size() > 1){
            return list.subList(1,list.size());
        }
       return null;
    }

    @Override
    public ReturnT<List<FrontMenuView>> getFrontMenuView(QueryFrontMenuParam param) {
        FrontMenu frontMenu = new FrontMenu();
        BeanUtils.copyProperties(param, frontMenu);
        frontMenu.setStatus(StatusEnum.ENABLE.getCode());
        frontMenu.setParentId(0l);
        frontMenu.putExtendedParameterValue("sidx","ordered");
        frontMenu.putExtendedParameterValue("sord","asc");
        List<FrontMenu> topList = frontMenuMapper.query(frontMenu);//查询一级菜单
        if(topList.isEmpty()){
            return new ReturnT<>().successDefault();
        }
        List<FrontMenuView> frontMenuViewList = new ArrayList<>(topList.size());
        for(FrontMenu menu : topList){
            FrontMenuView frontMenuView = new FrontMenuView().toView(menu);
            processMenuList(frontMenuView);
            frontMenuViewList.add(frontMenuView);
        }
        return new ReturnT<>().sucessData(frontMenuViewList);
    }

    private void processMenuList(FrontMenuView frontMenuView){
        Long parentId = frontMenuView.getId();
        if(parentId == null){
            return;
        }
        FrontMenu frontMenu = new FrontMenu();
        frontMenu.setParentId(parentId);
        frontMenu.setStatus(StatusEnum.ENABLE.getCode());
        List<FrontMenu> list = frontMenuMapper.query(frontMenu);
        if(!list.isEmpty()){//有子元素
            frontMenuView.setHasChildren(true);
            List<FrontMenuView> viewList = new ArrayList<>(list.size());
            for(FrontMenu menu :list){
                FrontMenuView view = new FrontMenuView().toView(menu);
                processMenuList(view);
                viewList.add(view);
            }
            frontMenuView.setChildren(viewList);
        }
    }


}
