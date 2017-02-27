package com.dky.website.web.controller.front;

import com.dky.website.business.biz.ProductService;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangpeng on 2017/2/27.
 */
@RestController
@RequestMapping("front/product")
public class FrontProductController {


    @Autowired
    private ProductService productService;


    @RequestMapping("getProduct")
    public ReturnT getProduct(QueryProductParam param){
        return productService.queryProductList(param);
    }



}
