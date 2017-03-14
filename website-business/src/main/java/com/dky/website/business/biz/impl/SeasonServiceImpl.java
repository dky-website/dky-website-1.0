package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.business.biz.SeasonService;
import com.dky.website.business.mapper.SeasonMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.QuerySeasonWithProduct;
import com.dky.website.common.bean.Season;
import com.dky.website.common.enums.SeasonTypeEnum;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddSeasonParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.QuerySeasonParam;
import com.dky.website.common.param.UpdateSeasonParam;
import com.dky.website.common.response.ProductTypeView;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.SeasonView;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hang on 2017/2/25.
 */
@Service
public class SeasonServiceImpl implements SeasonService{

    @Autowired
    private SeasonMapper mapper;

    @Override
    public PageHelper.Page<Season> querySeasonPage(QuerySeasonParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        Season season = new Season();
        BeanUtils.copyProperties(param, season);
        season.setStatus(StatusEnum.ENABLE.getCode());
        mapper.query(season);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT<List<Season>> querySeasonList(QuerySeasonParam param) {
        Season season = new Season();
        BeanUtils.copyProperties(param, season);
        season.setStatus(StatusEnum.ENABLE.getCode());
        List<Season> list = mapper.query(season);
        return new ReturnT<>().sucessData(list);
    }

    @Override
    public ReturnT addSeason(AddSeasonParam param) {
        Season season = new Season();
        BeanUtils.copyProperties(param, season);
        Date now = new Date();
        season.setCreatetime(now);
        season.setUpdatetime(now);
        mapper.insert(season);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updateSeason(UpdateSeasonParam param) {
        Season season = new Season();
        BeanUtils.copyProperties(param, season);
        Date now = new Date();
        season.setUpdatetime(now);
        mapper.insert(season);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<Season> querySeasonById(Long id) {
        return new ReturnT<>(mapper.selectByPrimaryKey(id));
    }

    @Override
    public ReturnT deleteSeasonById(Long id) {
        Season season = new Season();
        season.setId(id);
        season.setStatus(StatusEnum.DISABLED.getCode());
        mapper.updateByPrimaryKeySelective(season);
        return new ReturnT().successDefault();
    }

    @Override
    public Season getSeanByType(Integer type) {
        Season season = new Season();
        season.setType(type);
        season.setStatus(StatusEnum.ENABLE.getCode());
        List<Season> list = mapper.query(season);
        if(list == null || list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    @Autowired
    private FrontMenuService frontMenuService;

    @Override
    public ReturnT<List<SeasonView>> querySeasonView(QueryProductParam param) {
        Long seasonId = null;
        if(StringUtils.isNoneEmpty(param.getSeason())){
            seasonId =  Long.parseLong(param.getSeason());
        }
        QuerySeasonWithProduct sp = new QuerySeasonWithProduct();
        if(StringUtils.isEmpty(param.getType())){//如果type为空默认查询第一个分类的所有季节
            ReturnT<List<ProductTypeView>> productTypeR = frontMenuService.getProductTypeView(param);
            if(productTypeR.isSuccess()){
                List<ProductTypeView> productTypeViews = productTypeR.getData();
                ProductTypeView typeView = productTypeViews.get(0);
                sp.setType(typeView.getId());
            }
        }else {
            sp.setType(param.getType());
        }
        sp.setSeason(seasonId);
        List<Season> list = mapper.queryWithProduct(sp);
        if(list == null || list.size() == 0){
            return new ReturnT<>().failureData("没有符合条件的数据");
        }
        List<SeasonView> viewList = new SeasonView().toViewList(list);
        return new ReturnT<>().sucessData(viewList);
    }

}
