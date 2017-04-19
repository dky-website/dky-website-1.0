package com.dky.website.business.mapper;

import com.dky.website.common.bean.ProductImg;

import java.util.List;

@MyBatisRepository
public interface ProductImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductImg record);

    int insertSelective(ProductImg record);

    ProductImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductImg record);

    int updateByPrimaryKey(ProductImg record);

    List<ProductImg> query(ProductImg productImg);

    List<ProductImg> queryProductImgList(ProductImg productImg);
}