package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.SeasonService;
import com.dky.website.business.mapper.SeasonMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Season;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddSeasonParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.QuerySeasonParam;
import com.dky.website.common.param.UpdateSeasonParam;
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
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
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

    @Override
    public ReturnT<List<SeasonView>> querySeasonView(QueryProductParam param) {
        Season season = new Season();
        season.setStatus(StatusEnum.ENABLE.getCode());
        if(StringUtils.isNoneEmpty(param.getSeason())){
            season.setType(Integer.parseInt(param.getType()));
        }
        List<Season> list = mapper.query(season);
        if(list == null || list.size() == 0){
            return new ReturnT<>().sucessData("没有符合条件的数据");
        }
        List<SeasonView> viewList = new SeasonView().toViewList(list);
        return new ReturnT<>().sucessData(viewList);
    }
}
