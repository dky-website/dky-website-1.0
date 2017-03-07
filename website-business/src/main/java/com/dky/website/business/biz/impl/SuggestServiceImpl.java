package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.SuggestService;
import com.dky.website.business.mapper.SuggestMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Suggest;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.param.QuerySuggestParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by wonpera on 2017/2/24.
 */
@Service
public class SuggestServiceImpl implements SuggestService {


    @Autowired
    private SuggestMapper suggestMapper;

    @Override
    public ReturnT addSuggest(AddFrontSuggestParam param) {
        Suggest suggest = new Suggest();
        BeanUtils.copyProperties(param,suggest);
        suggest.setStatus(StatusEnum.ENABLE.getCode());
        Date now = new Date();
        suggest.setCreateTime(now);
        suggest.setUpdateTime(now);
        suggestMapper.insert(suggest);
        return new ReturnT().successDefault();
    }

    @Override
    public PageHelper.Page<Suggest> querySuggestPage(QuerySuggestParam param) {
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        Suggest suggest = new Suggest();
        BeanUtils.copyProperties(param,suggest);
        suggestMapper.query(suggest);
        return PageHelper.endPage();
    }
}
