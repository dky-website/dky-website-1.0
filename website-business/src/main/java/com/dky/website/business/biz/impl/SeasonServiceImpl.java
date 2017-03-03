package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.SeasonService;
import com.dky.website.business.mapper.SeasonMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Season;
import com.dky.website.common.param.AddSeasonParam;
import com.dky.website.common.param.QuerySeasonParam;
import com.dky.website.common.param.UpdateSeasonParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
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
    public PageHelper.Page<Season> querySeasonList(QuerySeasonParam param) {
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        Season season = new Season();
        BeanUtils.copyProperties(param, season);
        mapper.querySeasonList(season);
        return PageHelper.endPage();
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
}
