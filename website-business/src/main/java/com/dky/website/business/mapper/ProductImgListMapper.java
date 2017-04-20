package com.dky.website.business.mapper;

import com.dky.website.common.bean.ProductImgList;

@MyBatisRepository
public interface ProductImgListMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductImgList record);

    int insertSelective(ProductImgList record);

    ProductImgList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ProductImgList record);

    int updateByPrimaryKey(ProductImgList record);
}