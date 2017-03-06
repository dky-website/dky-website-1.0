package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Show;
import com.dky.website.common.param.*;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;


/**
 * Created by wonpera on 2017/2/24.
 */
public interface ShowService {

    ReturnT<ShowPageView> getShowImg(QueryFrontShowParam param);

    ReturnT<ShowView> getOldShowImg(QueryFrontShowParam param);

    PageHelper.Page<Show> queryShowPage(QueryFrontShowParam param);

    ReturnT addShow(AddShowParam param);

    ReturnT updateShow(UpdShowParam param);

    ReturnT deleteShow(Long id);

    ReturnT<Show> getShowById(Long id);
}
