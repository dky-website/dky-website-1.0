package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.Season;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonpera on 2017/3/5.
 */
public class SeasonView extends BaseParameter {

    private String type;

    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SeasonView toView(Season season){
        if(season == null){
            return null;
        }
        SeasonView seasonView = new SeasonView();
        seasonView.setType(String.valueOf(season.getType()));
        seasonView.setName(season.getName());
        return seasonView;
    }

    public List<SeasonView> toViewList(List<Season> list){
        if(list == null || list.size() == 0){
            return null;
        }
        List<SeasonView> viewList = new ArrayList<>(list.size());
        for(Season season : list){
            viewList.add(toView(season));
        }
        return viewList;
    }
}
