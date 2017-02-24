package com.dky.website.business.mapper;

import com.dky.website.common.bean.FrontMenu;

import java.util.List;

@MyBatisRepository
public interface FrontMenuMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FrontMenu record);

    int insertSelective(FrontMenu record);

    FrontMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FrontMenu record);

    int updateByPrimaryKeyWithBLOBs(FrontMenu record);

    int updateByPrimaryKey(FrontMenu record);

    List<FrontMenu> query(FrontMenu frontMenu);
}