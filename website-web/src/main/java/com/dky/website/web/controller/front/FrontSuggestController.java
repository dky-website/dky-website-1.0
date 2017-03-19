package com.dky.website.web.controller.front;

import com.dky.website.business.biz.SuggestService;
import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by hang on 2017/2/27.
 */
@RestController
@RequestMapping("front/suggest")
public class FrontSuggestController {


    @Autowired
    private SuggestService suggestService;


    @RequestMapping("addSuggest")
    public ReturnT getProductWithImg(@Valid AddFrontSuggestParam param,BindingResult bindingResult,HttpServletRequest request){
        if(bindingResult != null && bindingResult.hasErrors()){
            String errorMsg = bindingResult.getFieldError().getDefaultMessage();
            return new ReturnT().failureData(errorMsg);
        }
        try {

            String name = URLDecoder.decode(param.getName(), "UTF-8"); // new String(request.getParameter("name").getBytes(), "UTF-8");
            String title =  URLDecoder.decode(param.getTitle(), "UTF-8");//new String(request.getParameter("title").getBytes(), "UTF-8");
            String content =  URLDecoder.decode(param.getContent(), "UTF-8");//new String(request.getParameter("content").getBytes(), "UTF-8");
            param.setName(name);
            param.setTitle(title);
            param.setContent(content);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return suggestService.addSuggest(param);
    }
}
