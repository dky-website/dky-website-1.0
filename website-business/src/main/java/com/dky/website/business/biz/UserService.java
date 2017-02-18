package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.User;
import com.dky.website.common.param.QueryUserParam;

/**
 * Created by wonpera on 2017/2/18.
 */
public interface UserService {

    PageHelper.Page<User> queryUserPage(QueryUserParam param);
}
