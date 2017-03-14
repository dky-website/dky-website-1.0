package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;


/**
 * Created by hang on 2017/2/28.
 */
public class ShowView extends BaseParameter {

    private Long id;

    private Long seasonId;

    private String showSeason;

    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShowSeason() {
        return showSeason;
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public void setShowSeason(String showSeason) {
        this.showSeason = showSeason;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
