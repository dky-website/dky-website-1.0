package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Season;
import com.dky.website.common.param.AddSeasonParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.QuerySeasonParam;
import com.dky.website.common.param.UpdateSeasonParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.SeasonView;

import java.util.List;

/**
 * Created by hang on 2017/2/25.
 */
public interface SeasonService {

    PageHelper.Page<Season> querySeasonPage(QuerySeasonParam param);

    ReturnT<List<Season>> querySeasonList(QuerySeasonParam param);

    ReturnT addSeason(AddSeasonParam param);

    ReturnT updateSeason(UpdateSeasonParam param);

    ReturnT<Season> querySeasonById(Long id);

    ReturnT deleteSeasonById(Long id);

    Season getSeanByType(Integer type);

    ReturnT<List<SeasonView>> querySeasonView(QueryProductParam param);
}
