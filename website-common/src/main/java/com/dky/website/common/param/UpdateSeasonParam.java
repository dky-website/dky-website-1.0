package com.dky.website.common.param;

import com.dky.website.common.base.SessionParameter;

/**
 * Created by hang on 2017/2/25.
 */
public class UpdateSeasonParam extends SessionParameter{

    private String name;

    private Integer type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
