package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wonpera on 2017/2/24.
 */
public class QueryFrontShowParam extends WebPageParameter {

    private Long id;

    private String showseason;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShowseason() {
        return showseason;
    }

    public void setShowseason(String showseason) {
        this.showseason = showseason;
    }
}
