package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.Banner;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by hang on 2017/2/28.
 */
public class ShowView extends BaseParameter {

    private Long id;

    private String showSeason;

    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShowSeason() {
        return showSeason;
    }

    public void setShowSeason(String showSeason) {
        this.showSeason = showSeason;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }
}
