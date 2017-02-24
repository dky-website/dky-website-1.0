package com.dky.website.business.mapper;

import com.dky.website.common.bean.Product;

import java.util.List;

@MyBatisRepository
public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    List<Product> query(Product product);
}