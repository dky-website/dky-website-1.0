package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ShowService;
import com.dky.website.business.biz.SuggestService;
import com.dky.website.business.mapper.ShowMapper;
import com.dky.website.business.mapper.SuggestMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Show;
import com.dky.website.common.bean.Suggest;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.*;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowMapper showMapper;

    @Override
    public ReturnT<ShowPageView> getShowImg(QueryFrontShowParam param) {
        ReturnT<ShowPageView> result = new ReturnT<>();
        ShowPageView resultView = new ShowPageView();
        resultView.setMiddleShow(showMapper.getShowView(param.getId()));
        resultView.setOldShowList(showMapper.queryOldShowList());
        result.setData(resultView);
        return result.successDefault();
    }

    @Override
    public ReturnT<ShowView> getOldShowImg(QueryFrontShowParam param) {
        ReturnT<ShowView> result = new ReturnT<>();
        result.setData(showMapper.getShowView(param.getId()));
        return result.successDefault();
    }

    @Override
    public PageHelper.Page<Show> queryShowPage(QueryFrontShowParam param) {
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setStatus(StatusEnum.ENABLE.getCode());
        showMapper.query(show);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT addShow(AddShowParam param) {
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setStatus(StatusEnum.ENABLE.getCode());
        show.setCreatetime(new Date());
        show.setUpdatetime(new Date());
        showMapper.insertSelective(show);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updateShow(UpdShowParam param) {
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setUpdatetime(new Date());
        showMapper.updateByPrimaryKeySelective(show);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT deleteShow(Long id) {
        Show show = new Show();
        show.setStatus(StatusEnum.DISABLED.getCode());
        show.setId(id);
        showMapper.updateByPrimaryKeySelective(show);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<Show> getShowById(Long id) {
        return new ReturnT<>().sucessData(showMapper.selectByPrimaryKey(id));
    }
}
