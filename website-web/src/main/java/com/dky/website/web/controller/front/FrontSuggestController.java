package com.dky.website.web.controller.front;

import com.dky.website.business.biz.SuggestService;
import com.dky.website.common.param.AddSuggestParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hang on 2017/2/27.
 */
@RestController
@RequestMapping("front/suggest")
public class FrontSuggestController {


    @Autowired
    private SuggestService suggestService;


    @RequestMapping("addSuggest")
    public ReturnT getProductWithImg(AddSuggestParam param){
        return suggestService.addSuggest(param);
    }
}
