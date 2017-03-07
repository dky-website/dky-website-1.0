package com.dky.website.web.controller;

import com.dky.website.business.biz.SuggestService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Suggest;
import com.dky.website.common.param.QuerySuggestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wonpera on 2017/3/7.
 */
@RestController
@RequestMapping("suggest")
public class SuggestController {

    @Autowired
    private SuggestService suggestService;

    @RequestMapping("list")
    public ModelAndView getSuggestPage(){
        return new ModelAndView("suggest/suggest-list");
    }

    @RequestMapping("page")
    public PageHelper.Page<Suggest> querySuggestPage(QuerySuggestParam param){
        return suggestService.querySuggestPage(param);
    }
}
