package com.dky.website.web.controller;

import com.dky.website.business.biz.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

}
