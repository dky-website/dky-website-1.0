package com.dky.website.common.param;

import com.dky.website.common.base.WebPageParameter;

/**
 * Created by wonpera on 2017/2/24.
 */
public class QueryFrontShowParam extends WebPageParameter {

    private Long seasonId;

    private String showseason;

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public String getShowseason() {
        return showseason;
    }

    public void setShowseason(String showseason) {
        this.showseason = showseason;
    }
}
