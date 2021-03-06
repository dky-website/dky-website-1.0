package com.dky.website.web.controller.front;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.business.biz.ProductService;
import com.dky.website.business.biz.SeasonService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.ProductImg;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.response.ProductTypeView;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.SeasonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/27.
 */
@RestController
@RequestMapping("front/product")
public class FrontProductController {


    @Autowired
    private ProductService productService;

    @Autowired
    private FrontMenuService frontMenuService;

    @Autowired
    private SeasonService seasonService;


    @RequestMapping("list")
    public ReturnT getProductWithImg(QueryProductParam param){
        return productService.getFrontProduct(param);
    }

    @RequestMapping("queryProduct")
    public ReturnT queryProduct(QueryProductParam param){
        return productService.getFrontProductView(param);
    }


    @RequestMapping("queryProductType")
    public ReturnT<List<ProductTypeView>> queryProductType(QueryProductParam param){
        return frontMenuService.getProductTypeView(param);
    }


    /**
     * 根据产品id获取系列
     * @param param
     * @return
     */
    @RequestMapping("querySeasonList")
    public ReturnT<List<SeasonView>> getSeasonList(QueryProductParam param){
        return seasonService.querySeasonView(param);
    }


    @RequestMapping("queryImgListByPage")
    public ReturnT<PageHelper.Page<ProductImg>> queryImgListByPage(QueryProductParam param){
        return productService.queryImgListByPage(param);
    }





   /* @RequestMapping("getProductType")
    public ReturnT<List<FrontMenuView>> getProductType(){
        List<FrontMenu> list = frontMenuService.getProductTypeWithOutChoice();
        List<FrontMenuView> viewList = new FrontMenuView().toViewList(list);
        if(list == null){
            return new ReturnT<>().failureData("请先配置产品菜单信息");
        }
        return new ReturnT<>().sucessData(viewList);
    }*/

}
