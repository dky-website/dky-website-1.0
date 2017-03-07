package com.dky.website.web.controller.front;

import com.dky.website.business.biz.SuggestService;
import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by hang on 2017/2/27.
 */
@RestController
@RequestMapping("front/suggest")
public class FrontSuggestController {


    @Autowired
    private SuggestService suggestService;


    @RequestMapping("addSuggest")
    public ReturnT getProductWithImg(@Valid AddFrontSuggestParam param,BindingResult bindingResult){
        if(bindingResult != null && bindingResult.hasErrors()){
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return new ReturnT().failureData(errorMsg);
        }
        return suggestService.addSuggest(param);
    }
}
