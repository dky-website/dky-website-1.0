package com.dky.website.web.controller;

import com.dky.website.business.biz.BannerService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Banner;
import com.dky.website.common.param.AddBannerParam;
import com.dky.website.common.param.QueryBannerParam;
import com.dky.website.common.param.UpdBannerParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
@RestController
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    /**
     * 跳转到列表页面
     * @return
     */
    @RequestMapping("list")
    public ModelAndView listPage(){
        return new ModelAndView("banner/banner-list");
    }


    @RequestMapping("page")
    public PageHelper.Page<Banner> queryPage(QueryBannerParam param){
        return bannerService.queryBannerPage(param);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ReturnT addBanner(AddBannerParam param){
        return bannerService.addBanner(param);
    }


    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ReturnT updateBanner(UpdBannerParam param){
        return bannerService.updBanner(param);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ReturnT deleteBanner(@RequestParam(value = "id")Long id){
        return bannerService.deleteBanner(id);
    }

    @RequestMapping(value = "getBannerById")
    public ReturnT getBannerById(@RequestParam(value = "id")Long id){
        return bannerService.getBannerById(id);
    }

}
