package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ShowService;
import com.dky.website.business.biz.SuggestService;
import com.dky.website.business.mapper.ShowMapper;
import com.dky.website.business.mapper.SuggestMapper;
import com.dky.website.common.bean.Show;
import com.dky.website.common.bean.Suggest;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowMapper showMapper;

    @Override
    public ReturnT<ShowPageView> getShowImg(QueryFrontShowParam param) {
        ReturnT<ShowPageView> result = new ReturnT<>();
        ShowPageView resultView = new ShowPageView();
        resultView.setMiddleShow(showMapper.getShowView(param.getId()));
        resultView.setOldShowList(showMapper.queryOldShowList());
        result.setData(resultView);
        return result.successDefault();
    }

    @Override
    public ReturnT<ShowView> getOldShowImg(QueryFrontShowParam param) {
        ReturnT<ShowView> result = new ReturnT<>();
        result.setData(showMapper.getShowView(param.getId()));
        return result.successDefault();
    }
}
