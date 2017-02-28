package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.BannerService;
import com.dky.website.business.mapper.BannerMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Banner;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddBannerParam;
import com.dky.website.common.param.QueryBannerParam;
import com.dky.website.common.param.UpdBannerParam;
import com.dky.website.common.response.BannerView;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
@Service
public class BannerServiceImpl implements BannerService {


    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public PageHelper.Page<Banner> queryBannerPage(QueryBannerParam param) {
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        Banner banner = new Banner();
        BeanUtils.copyProperties(param,banner);
        banner.setStatus(StatusEnum.ENABLE.getCode());
        bannerMapper.query(banner);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT<List<Banner>> queryBannerList(QueryBannerParam param) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(param,banner);
        banner.setStatus(StatusEnum.ENABLE.getCode());
        List<Banner> list = bannerMapper.query(banner);
        return new ReturnT<>().sucessData(list);
    }

    @Override
    public ReturnT addBanner(AddBannerParam param) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(param,banner);
        banner.setCreateTime(new Date());
        banner.setStatus(StatusEnum.ENABLE.getCode());
        bannerMapper.insertSelective(banner);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updBanner(UpdBannerParam param) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(param, banner);
        banner.setUpdateTime(new Date());
        bannerMapper.updateByPrimaryKeySelective(banner);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT deleteBanner(Long id) {
        Banner banner = new Banner();
        banner.setId(id);
        banner.setStatus(StatusEnum.DISABLED.getCode());
        bannerMapper.updateByPrimaryKeySelective(banner);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<Banner> getBannerById(Long id) {
        return new ReturnT<>().sucessData(bannerMapper.selectByPrimaryKey(id));
    }

    @Override
    public ReturnT<List<BannerView>> queryBannerView(QueryBannerParam param) {
        Banner banner = new Banner();
        BeanUtils.copyProperties(param,banner);
        banner.setStatus(StatusEnum.ENABLE.getCode());
        List<Banner> list = bannerMapper.query(banner);
        return new ReturnT<>().sucessData(new BannerView().toViewList(list));
    }
}
