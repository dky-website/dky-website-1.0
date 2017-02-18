package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.UserService;
import com.dky.website.business.mapper.UserMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.User;
import com.dky.website.common.param.QueryUserParam;
import com.dky.website.common.response.ReturnT;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ReturnT login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        List<User> userList = userMapper.query(user);
        if(userList.isEmpty()){
            return new ReturnT().failureData("用户不存在");
        }
        User u = userList.get(0);
        if(!password.equals(u.getPassword())){
            return new ReturnT().failureData("用户密码错误");
        }
        //登录成功
        return new ReturnT().sucessData(u);
    }
}
