package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.FrontMenuService;
import com.dky.website.business.biz.ProductImgService;
import com.dky.website.business.biz.ProductService;
import com.dky.website.business.biz.SeasonService;
import com.dky.website.business.mapper.ProductImgMapper;
import com.dky.website.business.mapper.ProductMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.FrontMenu;
import com.dky.website.common.bean.Product;
import com.dky.website.common.bean.ProductImg;
import com.dky.website.common.bean.Season;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddProductParam;
import com.dky.website.common.param.QueryProductImgParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.UpdProductParam;
import com.dky.website.common.response.FrontProductView;
import com.dky.website.common.response.ReturnT;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangpeng on 2017/2/27.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper mapper;

    @Override
    public PageHelper.Page<Product> queryProductPage(QueryProductParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        Product product = new Product();
        BeanUtils.copyProperties(param,product);
        Map<String,String> extendedParameter = Maps.newHashMap();
        extendedParameter.put("sidx","ordered");
        extendedParameter.put("sord","asc");
        product.setExtendedParameter(extendedParameter);
        mapper.query(product);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT<List<Product>> queryProductList(QueryProductParam param) {
        Product product = new Product();
        BeanUtils.copyProperties(param,product);
        Map<String,String> extendedParameter = Maps.newHashMap();
        extendedParameter.put("sidx","ordered");
        extendedParameter.put("sord","asc");
        List<Product> list = mapper.query(product);
        return new ReturnT<>().sucessData(list);
    }

    @Override
    public ReturnT addProduct(AddProductParam param) {
        Product product = new Product();
        BeanUtils.copyProperties(param,product);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        product.setStatus(StatusEnum.ENABLE.getCode());
        mapper.insertSelective(product);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updateProduct(UpdProductParam param) {
        Product product = new Product();
        BeanUtils.copyProperties(param,product);
        product.setUpdateTime(new Date());
        mapper.updateByPrimaryKeySelective(product);
        return new ReturnT().successDefault();
    }


    @Autowired
    private ProductImgService productImgService;

    @Override
    public ReturnT deleteProduct(Long id) {
        Product product = new Product();
        product.setStatus(StatusEnum.DISABLED.getCode());
        product.setId(id);
        product.setUpdateTime(new Date());
        mapper.updateByPrimaryKeySelective(product);
        //删除相关imglist的信息
        QueryProductImgParam param = new QueryProductImgParam();
        param.setProductId(id);
        ReturnT<List<ProductImg>> returnT = productImgService.queryProductImgList(param);
        List<ProductImg> productImgList = returnT.getData();
        if(productImgList != null && productImgList.size() > 0){
            for(ProductImg productImg : productImgList){
                productImgService.deleteProductImg(productImg.getId());
            }
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<Product> getProductById(Long id) {
        Product product = mapper.selectByPrimaryKey(id);
        if(product == null){
            return new ReturnT<>().failureData("记录不存在");
        }
        return new ReturnT<>().sucessData(product);
    }

    @Autowired
    private ProductImgMapper imgMapper;

    @Autowired
    private FrontMenuService frontMenuService;


    /**
     * 前端查询产品图片
     * @param param
     * @return
     */
    @Override
    public ReturnT<FrontProductView> getFrontProductView(QueryProductParam param) {
        Product product = new Product();
        BeanUtils.copyProperties(param, product);
        product.putExtendedParameterValue("sidx", "type,season,ordered");
        product.putExtendedParameterValue("sord","asc");
        List<Product> productList = mapper.query(product);
        if(productList == null || productList.size() == 0){
            return new ReturnT<>().failureData("没有符合条件的记录");
        }
        //默认取第一条
        FrontProductView productView = new FrontProductView().toView(productList.get(0));
        //query imgList
        ProductImg productImg = new ProductImg();
        productImg.setStatus(StatusEnum.ENABLE.getCode());
        productImg.setProductId(productView.getId());
        List<ProductImg> imgList = imgMapper.query(productImg);
        if(imgList != null && imgList.size() > 0){
            productView.setImgList(imgList);
        }
        return new ReturnT<>().sucessData(productView);
    }

    @Autowired
    private SeasonService seasonService;

    @Override
    public ReturnT<List<FrontProductView>> getFrontProduct(QueryProductParam param) {
        //获取type
        List<FrontMenu> menuList = null;
        if(StringUtils.isEmpty(param.getType())){
            menuList = frontMenuService.getProductTypeWithOutChoice();
        }else {
            ReturnT<FrontMenu> returnT = frontMenuService.getFMenuById(Long.parseLong(param.getType()));
            menuList = new ArrayList<>(1);
            menuList.add(returnT.getData());
        }
        if(menuList == null || menuList.size() == 0){
            return new ReturnT<>().failureData("没有符合条件的数据");
        }
        List<FrontProductView> viewList = new ArrayList<>(menuList.size());
        for (FrontMenu menu : menuList){
            Product product = new Product();
            product.setStatus(StatusEnum.ENABLE.getCode());
            product.setType(String.valueOf(menu.getId()));
            if(StringUtils.isNoneBlank(param.getSeason())){
                product.setSeason(param.getSeason());
            }
            product.putExtendedParameterValue("sidx", "ordered");
            product.putExtendedParameterValue("sord","asc");
            List<Product> productList = mapper.query(product);
            if(productList == null || productList.size() == 0){
                continue;
            }
            //默认取第一条
            FrontProductView productView = new FrontProductView().toView(productList.get(0));
            //query imgList
            ProductImg productImg = new ProductImg();
            productImg.setStatus(StatusEnum.ENABLE.getCode());
            productImg.setProductId(productView.getId());
            List<ProductImg> imgList = imgMapper.query(productImg);
            if(imgList != null && imgList.size() > 0){
                productView.setImgList(imgList);
            }
            productView.setTypeName(menu.getMenuEnName());
            if(StringUtils.isNoneEmpty(productView.getSeason())){
                ReturnT seasonR = seasonService.querySeasonById(Long.parseLong(productView.getSeason()));
                if(seasonR != null && seasonR.getData()!=null){
                    Season season = (Season) seasonR.getData();
                    productView.setSeasonName(season.getName());
                }
            }
            viewList.add(productView);
        }
        return new ReturnT<>().sucessData(viewList);
    }
}
