package com.dky.website.web.controller;

import com.dky.website.business.biz.ProductImgService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.ProductImg;
import com.dky.website.common.param.AddProductImgParam;
import com.dky.website.common.param.QueryProductImgParam;
import com.dky.website.common.param.UpdProductImgParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wangpeng on 2017/2/27.
 */
@RestController
@RequestMapping("productImg")
public class ProductImgController {

    @Autowired
    private ProductImgService productImgService;

    @RequestMapping("list")
    public ModelAndView getProductImgPage(){
        return new ModelAndView("productImg/productImg-list");
    }

    @RequestMapping("page")
    public PageHelper.Page<ProductImg> queryProductImgPage(QueryProductImgParam param){
        return productImgService.queryProductImgPage(param);
    }


    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ReturnT addProductImg(AddProductImgParam param){
        return productImgService.addProductImg(param);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ReturnT updateProductImg(UpdProductImgParam param){
        return productImgService.updateProductImg(param);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ReturnT deleteProductImg(@RequestParam(value = "id")Long id){
        return productImgService.deleteProductImg(id);
    }

    @RequestMapping("getProductImg")
    public ReturnT getProductImgById(@RequestParam(value = "id")Long id){
        return productImgService.getProductImgById(id);
    }

}
