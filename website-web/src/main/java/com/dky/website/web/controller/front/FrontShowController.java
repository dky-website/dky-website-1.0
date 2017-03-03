package com.dky.website.web.controller.front;

import com.dky.website.business.biz.ShowService;
import com.dky.website.business.biz.SuggestService;
import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hang on 2017/2/27.
 */
@RestController
@RequestMapping("front/show")
public class FrontShowController {


    @Autowired
    private ShowService showService;

    @RequestMapping("showImageList")
    public ReturnT<ShowPageView> showImageList(QueryFrontShowParam param){
        return showService.getShowImg(param);
    }

    @RequestMapping("getOldShow")
    public ReturnT<ShowView> getOldShowImg(QueryFrontShowParam param){
        return showService.getOldShowImg(param);
    }
}
