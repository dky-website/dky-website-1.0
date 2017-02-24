package com.dky.website.business.mapper;

import com.dky.website.common.bean.Dictionary;

import java.util.List;

@MyBatisRepository
public interface DictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    Dictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Dictionary record);

    int updateByPrimaryKey(Dictionary record);

    List<Dictionary> query(Dictionary dictionary);
}