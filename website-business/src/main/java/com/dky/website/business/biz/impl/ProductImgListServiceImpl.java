package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ProductImgListService;
import com.dky.website.business.mapper.ProductImgListMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.business.plugin.PageHelper.Page;
import com.dky.website.common.bean.ProductImgList;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddProductImgListParam;
import com.dky.website.common.param.QueryProductImgListParam;
import com.dky.website.common.param.UpdProductImgListParam;
import com.dky.website.common.response.ReturnT;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangpeng on 2017/4/20.
 */
@Service
public class ProductImgListServiceImpl implements ProductImgListService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductImgListServiceImpl.class);

    @Autowired
    private ProductImgListMapper mapper;

    @Override
    public Page<ProductImgList> queryPage(QueryProductImgListParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        ProductImgList productImgList = new ProductImgList();
        BeanUtils.copyProperties(param,productImgList);
        mapper.query(productImgList);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT<List<ProductImgList>> queryList(QueryProductImgListParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        ProductImgList productImgList = new ProductImgList();
        BeanUtils.copyProperties(param,productImgList);
        List<ProductImgList> list = mapper.query(productImgList);
        return new ReturnT<>().sucessData(list);
    }

    @Override
    public ReturnT addImgList(AddProductImgListParam param) {
        try {
            ProductImgList productImgList = new ProductImgList();
            BeanUtils.copyProperties(param,productImgList);
            productImgList.setCreateTime(new Date());
            productImgList.setStatus(StatusEnum.ENABLE.getCode());
            mapper.insertSelective(productImgList);
        } catch (Exception e) {
            LOGGER.error("新增图片imglist失败，异常信息【{}】",e.getMessage());
            return new ReturnT().failureData("新增失败");
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updImgList(UpdProductImgListParam param) {
        try {
            ProductImgList productImgList = new ProductImgList();
            BeanUtils.copyProperties(param,productImgList);
            productImgList.setUpdateTime(new Date());
            mapper.updateByPrimaryKeySelective(productImgList);
        } catch (Exception e) {
            LOGGER.error("修改图片imglist失败，异常信息【{}】",e.getMessage());
            return new ReturnT().failureData("更新失败");
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT deleteImgList(Long id) {
        try {
            ProductImgList productImgList = new ProductImgList();
            productImgList.setId(id);
            productImgList.setStatus(StatusEnum.DISABLED.getCode());
            productImgList.setUpdateTime(new Date());
            mapper.updateByPrimaryKeySelective(productImgList);
        } catch (Exception e) {
            LOGGER.error("删除{}ImList数据失败",id);
            return new ReturnT().failureData("删除ImList数据失败");
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<ProductImgList> geteImgListById(Long id) {
        ProductImgList productImgList = mapper.selectByPrimaryKey(id);
        if(productImgList == null){
            LOGGER.error("获取id:{}的imglist数据失败",id);
            return new ReturnT<>().failureData("获取id:{"+id+"}的imglist数据失败");
        }
        return new ReturnT<>().sucessData(productImgList);
    }
}
