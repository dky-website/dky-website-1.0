package com.dky.website.web.controller;

import com.dky.website.business.biz.SeasonService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Season;
import com.dky.website.common.param.AddSeasonParam;
import com.dky.website.common.param.QuerySeasonParam;
import com.dky.website.common.param.UpdateSeasonParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hang on 2017/2/27.
 */
@RestController
@RequestMapping("season")
public class SeasonController {

    @Autowired
    private SeasonService seasonService;


    @RequestMapping("list")
    public ModelAndView getListPage(){
        return new ModelAndView("season/season-list");
    }

    @RequestMapping("page")
    public PageHelper.Page querySeasonList(QuerySeasonParam param){
        return seasonService.querySeasonPage(param);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ReturnT addSeason(AddSeasonParam param){
        return seasonService.addSeason(param);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ReturnT updateSeason(UpdateSeasonParam param){
        return seasonService.updateSeason(param);
    }

    @RequestMapping(value = "getSeasonById")
    public ReturnT getSeasonById(@RequestParam(value = "id")Long id){
        return seasonService.querySeasonById(id);
    }


    @RequestMapping("getSeanList")
    public ReturnT<List<Season>> getSeanList(QuerySeasonParam param){
        return seasonService.querySeasonList(param);
    }
}
