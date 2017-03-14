package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ShowService;
import com.dky.website.business.mapper.ShowMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Show;
import com.dky.website.common.bean.ShowGroupSeason;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddShowParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.param.UpdShowParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;
import com.dky.website.common.response.ShowVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by wonpera on 2017/2/24.
 */
@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowMapper showMapper;

    @Override
    public ReturnT<ShowPageView> getShowImg(QueryFrontShowParam param) {
        ReturnT<ShowPageView> result = new ReturnT<>();
        ShowPageView resultView = new ShowPageView();
        List<ShowView> showViewList = showMapper.getShowViewList(param.getSeasonId());
        resultView.setMiddleShowList(showViewList);
        List<ShowView> oldShowList = new ArrayList<>();
        if (showViewList.size() > 0){
            oldShowList = showMapper.queryOldShowList(showViewList.get(0).getSeasonId());
        }else {
            oldShowList = showMapper.queryOldShowList(null);
        }
        int index = 0;
        while (index < oldShowList.size() && oldShowList.size() > 0){
            for (int i=index+1;i<oldShowList.size();i++) {
                if (oldShowList.get(i).getShowSeason().equals(oldShowList.get(index).getShowSeason())){
                    oldShowList.remove(i);
                }
            }
            index ++;
        }

        resultView.setOldShowList(oldShowList);
        result.setData(resultView);
        return result.successDefault();
    }

    @Override
    public PageHelper.Page<ShowVo> queryShowPage(QueryFrontShowParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setStatus(StatusEnum.ENABLE.getCode());
        List<ShowGroupSeason> showGroupList = showMapper.queryGroupBySeason(show);
        PageHelper.Page page =  PageHelper.endPage();
        List<ShowVo> list = ShowVo.toShowVoList(showGroupList);
        PageHelper.Page<ShowVo> resultPage = new PageHelper.Page<ShowVo>();
        resultPage.setEndRow(page.getEndRow());
        resultPage.setPageNum(page.getPageNum());
        resultPage.setPages(page.getPages());
        resultPage.setPageSize(page.getPageSize());
        resultPage.setStartRow(page.getStartRow());
        resultPage.setTotal(page.getTotal());
        resultPage.setResult(list);
        return resultPage;
    }

    @Override
    public ReturnT addShow(AddShowParam param) {
        if(StringUtils.isEmpty(param.getImages())){
            return new ReturnT().failureData("请选择上传的图片");
        }
        String[] images = param.getImages().split(",");
        Date now = new Date();
        for(String image : images){
            Show show = new Show();
            show.setShowseason(param.getShowseason());
            show.setImage(image);
            show.setStatus(StatusEnum.ENABLE.getCode());
            show.setCreatetime(now);
            show.setUpdatetime(now);
            showMapper.insertSelective(show);
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updateShow(UpdShowParam param) {
        if(StringUtils.isEmpty(param.getIds())){
            return new ReturnT().failureData("更新失败");
        }
        String[] ids = param.getIds().split(",");
        String[] images = null;
        if(StringUtils.isNoneEmpty(param.getImages())){
            images = param.getImages().split(",");
        }
        Date now = new Date();
        for (int i = 0; i < ids.length; i++) {
            String image = null;
            if(images != null && i < images.length){
                image= images[i];
            }
            Long id = Long.parseLong(ids[i]);
            Show show = new Show();
            show.setId(id);
            show.setImage(image);
            show.setUpdatetime(now);
            showMapper.updateByPrimaryKeySelective(show);
        }
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT deleteShow(Long id) {
        Show show = new Show();
        show.setStatus(StatusEnum.DISABLED.getCode());
        show.setId(id);
        showMapper.updateByPrimaryKeySelective(show);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT<Show> getShowById(Long id) {
        return new ReturnT<>().sucessData(showMapper.selectByPrimaryKey(id));
    }

    @Override
    public ReturnT<ShowVo> getShowVoBySeansonId(String showseason) {
        Show show = new Show();
        show.setStatus(StatusEnum.ENABLE.getCode());
        show.setShowseason(showseason);
        List<ShowGroupSeason> showGroupList = showMapper.queryGroupBySeason(show);
        if(showGroupList == null || showGroupList.size() == 0){
            return new ReturnT<>().failureData("没有符合条件的数据");
        }
        ShowGroupSeason showGroupSeason = showGroupList.get(0);
        ShowVo showVo = ShowVo.toShowVo(showGroupSeason);
        return new ReturnT<>().sucessData(showVo);
    }
}
