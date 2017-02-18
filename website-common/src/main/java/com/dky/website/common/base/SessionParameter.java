package com.dky.website.common.base;

import com.dky.website.common.bean.User;

/**
 * Created by wonpera on 2017/2/18.
 */
public class SessionParameter extends BaseParameter {


    private String accessToken;

    private User sessionUser;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }
}
