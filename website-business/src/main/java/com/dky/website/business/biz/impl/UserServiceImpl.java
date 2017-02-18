package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.UserService;
import com.dky.website.business.mapper.UserMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.User;
import com.dky.website.common.param.QueryUserParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wonpera on 2017/2/18.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageHelper.Page<User> queryUserPage(QueryUserParam param) {
        PageHelper.startPage(param.getPageNo(),param.getPageSize());
        User user = new User();
        BeanUtils.copyProperties(param,user);
        userMapper.query(user);
        return PageHelper.endPage();
    }
}
