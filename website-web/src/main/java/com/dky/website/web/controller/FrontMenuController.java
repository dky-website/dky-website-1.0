package com.dky.website.web.controller;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.FrontMenu;
import com.dky.website.common.param.AddFrountMenuParam;
import com.dky.website.common.param.QueryFrontMenuParam;
import com.dky.website.common.param.UpdFrontMenuParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wonpera on 2017/2/25.
 */
@RestController
@RequestMapping("fmenu")
public class FrontMenuController {

    @Autowired
    private FrontMenuService frontMenuService;

    @RequestMapping("page")
    public PageHelper.Page<FrontMenu> queryFMenuByPage(QueryFrontMenuParam param){
        return frontMenuService.queryFMenuPage(param);
    }


    @RequestMapping("list")
    public ModelAndView getListPage(){
        return new ModelAndView("frontmenu/frontmenu-list");
    }

    @RequestMapping("add")
    public ReturnT addFrontMenu(AddFrountMenuParam param){
        return frontMenuService.addFMenu(param);
    }


    @RequestMapping("update")
    public ReturnT updateFrontMenu(UpdFrontMenuParam param){
        return frontMenuService.updateFMenu(param);
    }

    @RequestMapping("delete")
    public ReturnT deleteFrontMenu(@RequestParam(value = "id")Long id){
        return frontMenuService.deleteFMenu(id);
    }

    @RequestMapping("getFMenu")
    public ReturnT<FrontMenu> getFMenuById(@RequestParam(value = "id")Long id){
        return frontMenuService.getFMenuById(id);
    }
}
