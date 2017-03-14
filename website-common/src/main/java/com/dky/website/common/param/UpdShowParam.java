package com.dky.website.common.param;

import com.dky.website.common.base.BaseParameter;


/**
 * Created by wonpera on 2017/3/6.
 */
public class UpdShowParam extends BaseParameter {

    private String showseason;

    private String ids;

    private String images;

    public String getShowseason() {
        return showseason;
    }

    public void setShowseason(String showseason) {
        this.showseason = showseason;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }
}
