package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Banner;
import com.dky.website.common.param.AddBannerParam;
import com.dky.website.common.param.QueryBannerParam;
import com.dky.website.common.param.UpdBannerParam;
import com.dky.website.common.response.ReturnT;

import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
public interface BannerService {

    PageHelper.Page<Banner> queryBannerPage(QueryBannerParam param);

    ReturnT<List<Banner>> queryBannerList(QueryBannerParam param);

    ReturnT addBanner(AddBannerParam param);

    ReturnT updBanner(UpdBannerParam param);

    ReturnT deleteBanner(Long id);


    ReturnT<Banner> getBannerById(Long id);
}
