package com.dky.website.web.controller.front;

import com.dky.website.business.biz.BannerService;
import com.dky.website.common.bean.Banner;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.QueryBannerParam;
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
@RequestMapping("/front/banner")
public class FrontBannerController {

    @Autowired
    private BannerService bannerService;


    @RequestMapping("list")
    public ReturnT<List<Banner>> queryFrontBanner(QueryBannerParam param){
        return bannerService.queryBannerList(param);
    }
}
