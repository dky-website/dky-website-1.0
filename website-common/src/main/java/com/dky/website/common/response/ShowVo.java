package com.dky.website.common.response;

import com.dky.website.common.bean.ShowGroupSeason;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangpeng on 2017/3/14.
 */
public class ShowVo {

    private String showseason;

    private List<ShowData> showDataList;

    public String getShowseason() {
        return showseason;
    }

    public void setShowseason(String showseason) {
        this.showseason = showseason;
    }

    public List<ShowData> getShowDataList() {
        return showDataList;
    }

    public void setShowDataList(List<ShowData> showDataList) {
        this.showDataList = showDataList;
    }

    public static List<ShowVo> toShowVoList(List<ShowGroupSeason> showGroupSeasonList){
        if(showGroupSeasonList == null || showGroupSeasonList.size() == 0){
            return null;
        }
        List<ShowVo> list = new ArrayList<>();
        for(ShowGroupSeason showGroupSeason : showGroupSeasonList){
            ShowVo showVo = toShowVo(showGroupSeason);
            if(showVo != null){
                list.add(showVo);
            }
        }
        return list;
    }

    public static ShowVo toShowVo(ShowGroupSeason showGroupSeason){
        if(showGroupSeason == null){
            return null;
        }
        if(StringUtils.isEmpty(showGroupSeason.getGroupConcatIds())){
            return null;
        }
        String[] ids = showGroupSeason.getGroupConcatIds().split(",");
        String[] images =  null;
        if(StringUtils.isNoneBlank(showGroupSeason.getGetGroupConcatImages())){
            images = showGroupSeason.getGetGroupConcatImages().split(",");
        }
        if(ids.length == 0){
            return null;
        }
        ShowVo showVo = new ShowVo();
        showVo.setShowseason(showGroupSeason.getShowseason());
        List<ShowData> showDatas = new ArrayList<>(ids.length);
        for (int i = 0; i < ids.length; i++) {
            Long id = Long.parseLong(ids[i]);
            String image = null;
            if(images != null){
                if(ids.length == images.length){
                    image = images[i];
                }else if(i<images.length){
                    image = images[i];
                }
            }
            ShowData showData = new ShowData();
            showData.setId(id);
            showData.setImage(image);
            showDatas.add(showData);
        }
        showVo.setShowDataList(showDatas);
        return showVo;
    }

   static class ShowData{
        private Long id;
        private String image;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}
