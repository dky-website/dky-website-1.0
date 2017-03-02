package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.Banner;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by wonpera on 2017/2/28.
 */
public class BannerView extends BaseParameter {

    private Long id;

    private String bannerName;

    private String bannerType;

    private String path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerType() {
        return bannerType;
    }

    public void setBannerType(String bannerType) {
        this.bannerType = bannerType;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BannerView toView(Banner banner){
        if(banner != null){
            BeanUtils.copyProperties(banner,this);
        }
        return this;
    }

    public List<BannerView> toViewList(List<Banner> list){
        if(list.isEmpty()){
            return null;
        }
        List<BannerView> viewList = new ArrayList<>(list.size());
        for(Banner banner : list){
            viewList.add(new BannerView().toView(banner));
        }
        return viewList;
    }
}
