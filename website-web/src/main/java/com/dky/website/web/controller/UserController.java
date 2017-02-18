package com.dky.website.web.controller;

import com.dky.website.business.biz.UserService;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.User;
import com.dky.website.common.constats.GlobConts;
import com.dky.website.common.param.QueryUserParam;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by wonpera on 2017/2/18.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("list")
    public ModelAndView listPage(){
        ModelAndView modelAndView = new ModelAndView("user/user-list");
        return modelAndView;
    }

    @RequestMapping("page")
    public PageHelper.Page<User> queryUserPage(QueryUserParam param){
        return userService.queryUserPage(param);
    }



    @RequestMapping("login")
    public ReturnT login(@RequestParam(value = "username")String username,
                         @RequestParam(value = "password")String password,HttpSession session){
        ReturnT returnT = userService.login(username,password);
        if(returnT.isSuccess()){
            //登录信息
            session.setAttribute(GlobConts.CURRENT_SESSION_KEY,returnT.getData());
        }
        return returnT;
    }
}
