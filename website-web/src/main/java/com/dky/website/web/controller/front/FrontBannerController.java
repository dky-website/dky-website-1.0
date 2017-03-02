package com.dky.website.web.controller.front;

import com.dky.website.business.biz.BannerService;
import com.dky.website.common.enums.BannerEnum;
import com.dky.website.common.param.QueryBannerParam;
import com.dky.website.common.response.BannerView;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 暴露给前端的banner接口
 * Created by wonpera on 2017/2/24.
 */
@RestController
@RequestMapping("front/banner")
public class FrontBannerController {

    @Autowired
    private BannerService bannerService;


    /**
     * 获取首页banner图片
     * @param param
     * @return
     */
    @RequestMapping("list")
    public ReturnT<List<BannerView>> queryFrontBanner(QueryBannerParam param){
        param.setBannerType(BannerEnum.INDEX.getCode());
        return bannerService.queryBannerView(param);
    }

    /**
     * 获取show banner图片
     * @param param
     * @return
     */
    @RequestMapping("showBannerList")
    public ReturnT<List<BannerView>> queryFrontBannerShow(QueryBannerParam param){
        param.setBannerType(BannerEnum.SHOW.getCode());
        return bannerService.queryBannerView(param);
    }
}
