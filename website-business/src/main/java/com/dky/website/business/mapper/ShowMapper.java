package com.dky.website.business.mapper;

import com.dky.website.common.bean.Show;
import com.dky.website.common.response.ShowView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@MyBatisRepository
public interface ShowMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Show record);

    int insertSelective(Show record);

    Show selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Show record);

    int updateByPrimaryKey(Show record);

    ShowView getShowView(@Param("id")Long id);

    List<ShowView> queryOldShowList(@Param("id")Long id);

    List<Show> query(Show show);
}