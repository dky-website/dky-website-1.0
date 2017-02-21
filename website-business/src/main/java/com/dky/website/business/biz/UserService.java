package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.User;
import com.dky.website.common.param.AddUserParam;
import com.dky.website.common.param.QueryUserParam;
import com.dky.website.common.param.UpdUserParam;
import com.dky.website.common.response.ReturnT;

/**
 * Created by wonpera on 2017/2/18.
 */
public interface UserService {

    PageHelper.Page<User> queryUserPage(QueryUserParam param);

    ReturnT login(String username,String password);

    ReturnT saveUser(AddUserParam param);

    ReturnT updateUser(UpdUserParam param);

    ReturnT deleteUser(Long id);
}
