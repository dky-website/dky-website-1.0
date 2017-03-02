package com.dky.website.business.biz;

import com.dky.website.common.param.AddFrontSuggestParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.response.ReturnT;

/**
 * Created by wonpera on 2017/2/24.
 */
public interface ShowService {

    ReturnT queryShowImgList(QueryFrontShowParam param);

    ReturnT queryOldShowList(QueryFrontShowParam param);
}
