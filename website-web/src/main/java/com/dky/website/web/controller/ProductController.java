package com.dky.website.web.controller;

import com.dky.website.business.biz.ProductService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Product;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddProductParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.UpdProductParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/27.
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("list")
    public ModelAndView getListPage(){
        return new ModelAndView("product/product-list");
    }


    @RequestMapping("page")
    public PageHelper.Page<Product> queryProductPage(QueryProductParam param){
        param.setStatus(StatusEnum.ENABLE.getCode());
        return productService.queryProductPage(param);
    }

    @RequestMapping("getProductList")
    public ReturnT<List<Product>> getProductList(QueryProductParam param){
        return productService.queryProductList(param);
    }

    @RequestMapping(value = "add",method = RequestMethod.POST)
    public ReturnT addProduct(AddProductParam param){
        return productService.addProduct(param);
    }

    @RequestMapping(value = "update",method = RequestMethod.POST)
    public ReturnT updateProduct(UpdProductParam param){
        return productService.updateProduct(param);
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    public ReturnT deleteProduct(@RequestParam(value = "id")Long id){
        return productService.deleteProduct(id);
    }

    @RequestMapping("getProduct")
    public ReturnT getProductById(@RequestParam(value = "id")Long id){
        return productService.getProductById(id);
    }



}
