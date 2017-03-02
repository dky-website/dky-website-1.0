package com.dky.website.business.mapper;

import com.dky.website.common.bean.Suggest;

public interface SuggestMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Suggest record);

    int insertSelective(Suggest record);

    Suggest selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Suggest record);

    int updateByPrimaryKey(Suggest record);
}