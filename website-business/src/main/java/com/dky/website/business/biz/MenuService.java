package com.dky.website.business.biz;

import com.dky.website.common.param.QueryMenuParameter;
import com.dky.website.common.response.ReturnT;

/**
 * Created by wonpera on 2017/2/18.
 */
public interface MenuService {

    ReturnT queryUserMenu(QueryMenuParameter queryMenuParameter);

}
