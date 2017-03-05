package com.dky.website.business.mapper;

import com.dky.website.common.bean.Season;

import java.util.List;


@MyBatisRepository
public interface SeasonMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Season record);

    int insertSelective(Season record);

    Season selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Season record);

    int updateByPrimaryKey(Season record);

    List<Season> query(Season record);

}