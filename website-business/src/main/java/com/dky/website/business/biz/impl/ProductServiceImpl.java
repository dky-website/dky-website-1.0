package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ProductService;
import com.dky.website.business.mapper.ProductImgMapper;
import com.dky.website.business.mapper.ProductMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Product;
import com.dky.website.common.bean.ProductImg;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddProductParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.UpdProductParam;
import com.dky.website.common.response.FrontProductView;
import com.dky.website.common.response.ReturnT;
import com.google.common.collect.Maps;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
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

    @Override
    public ReturnT deleteProduct(Long id) {
        Product product = new Product();
        product.setStatus(StatusEnum.DISABLED.getCode());
        product.setId(id);
        mapper.updateByPrimaryKeySelective(product);
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


    /**
     * 前端查询产品图片
     * @param param
     * @return
     */
    @Override
    public ReturnT<FrontProductView> getFrontProductView(QueryProductParam param) {
        Product product = new Product();
        BeanUtils.copyProperties(param, product);
        param.putExtendedParameterValue("sidx", "season,ordered");
        param.putExtendedParameterValue("sord","asc");
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
}
