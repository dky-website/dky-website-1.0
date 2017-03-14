package com.dky.website.common.bean;

import com.dky.website.common.base.BaseParameter;

/**
 * Created by wangpeng on 2017/3/14.
 */
public class ShowGroupSeason extends BaseParameter {

    private String showseason;

    private String groupConcatIds;

    private String getGroupConcatImages;

    public String getShowseason() {
        return showseason;
    }

    public void setShowseason(String showseason) {
        this.showseason = showseason;
    }

    public String getGroupConcatIds() {
        return groupConcatIds;
    }

    public void setGroupConcatIds(String groupConcatIds) {
        this.groupConcatIds = groupConcatIds;
    }

    public String getGetGroupConcatImages() {
        return getGroupConcatImages;
    }

    public void setGetGroupConcatImages(String getGroupConcatImages) {
        this.getGroupConcatImages = getGroupConcatImages;
    }
}
