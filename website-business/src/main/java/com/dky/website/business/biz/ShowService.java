package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Show;
import com.dky.website.common.param.AddShowParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.param.UpdShowParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowVo;


/**
 * Created by wonpera on 2017/2/24.
 */
public interface ShowService {

    ReturnT<ShowPageView> getShowImg(QueryFrontShowParam param);

    PageHelper.Page<ShowVo> queryShowPage(QueryFrontShowParam param);

    ReturnT addShow(AddShowParam param);

    ReturnT updateShow(UpdShowParam param);

    ReturnT deleteShow(Long id);

    ReturnT<Show> getShowById(Long id);

    ReturnT<ShowVo> getShowVoBySeansonId(String showseason);
}
