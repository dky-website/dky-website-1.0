package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;
import com.dky.website.common.bean.Season;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wonpera on 2017/3/5.
 */
public class SeasonView extends BaseParameter {

    private String id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SeasonView toView(Season season){
        if(season == null){
            return null;
        }
        SeasonView seasonView = new SeasonView();
        seasonView.setId(String.valueOf(season.getId()));
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
