package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.business.mapper.FrontMenuMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.FrontMenu;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddFrountMenuParam;
import com.dky.website.common.param.QueryFrontMenuParam;
import com.dky.website.common.param.UpdFrontMenuParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        frontMenuMapper.updateByPrimaryKeyWithBLOBs(frontMenu);
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
}
