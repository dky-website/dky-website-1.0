package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ShowService;
import com.dky.website.business.biz.SuggestService;
import com.dky.website.business.mapper.ShowMapper;
import com.dky.website.business.mapper.SuggestMapper;
import com.dky.website.common.bean.Suggest;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by wonpera on 2017/2/24.
 */
@Service
public class ShowServiceImpl implements ShowService {


    @Autowired
    private ShowMapper showMapper;

    @Override
    public ReturnT queryShowImgList(QueryFrontShowParam param) {
        return null;
    }

    @Override
    public ReturnT queryOldShowList(QueryFrontShowParam param) {
        return null;
    }
}
