package com.dky.website.web.controller;

import com.dky.website.business.biz.UserService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.User;
import com.dky.website.common.param.QueryUserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wonpera on 2017/2/18.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("page")
    public PageHelper.Page<User> queryUserPage(QueryUserParam param){
        return userService.queryUserPage(param);
    }
}
