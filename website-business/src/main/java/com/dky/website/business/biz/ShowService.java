package com.dky.website.business.biz;

import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;

import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
public interface ShowService {

    ReturnT<ShowPageView> getShowImg(QueryFrontShowParam param);

    ReturnT<ShowView> getOldShowImg(QueryFrontShowParam param);
}
