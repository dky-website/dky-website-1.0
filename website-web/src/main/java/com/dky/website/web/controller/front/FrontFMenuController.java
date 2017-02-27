package com.dky.website.web.controller.front;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.common.bean.FrontMenu;
import com.dky.website.common.param.QueryFrontMenuParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/27.
 */
@RestController
@RequestMapping("front/fmenu")
public class FrontFMenuController {

    @Autowired
    private FrontMenuService frontMenuService;


    /**
     * 获取菜单
     * @param param
     * @return
     */
    @RequestMapping("list")
    public ReturnT<List<FrontMenu>> getFrontMenuList(QueryFrontMenuParam param){
        return frontMenuService.queryFMenuList(param);
    }
}
