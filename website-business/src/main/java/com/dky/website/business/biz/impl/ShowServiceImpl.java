package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.ShowService;
import com.dky.website.business.mapper.ShowMapper;
import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Show;
import com.dky.website.common.enums.StatusEnum;
import com.dky.website.common.param.AddShowParam;
import com.dky.website.common.param.QueryFrontShowParam;
import com.dky.website.common.param.UpdShowParam;
import com.dky.website.common.response.ReturnT;
import com.dky.website.common.response.ShowPageView;
import com.dky.website.common.response.ShowView;
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
    public PageHelper.Page<Show> queryShowPage(QueryFrontShowParam param) {
        PageHelper.startPage(param.getPage(),param.getPageSize());
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setStatus(StatusEnum.ENABLE.getCode());
        showMapper.query(show);
        return PageHelper.endPage();
    }

    @Override
    public ReturnT addShow(AddShowParam param) {
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setStatus(StatusEnum.ENABLE.getCode());
        show.setCreatetime(new Date());
        show.setUpdatetime(new Date());
        showMapper.insertSelective(show);
        return new ReturnT().successDefault();
    }

    @Override
    public ReturnT updateShow(UpdShowParam param) {
        Show show = new Show();
        BeanUtils.copyProperties(param,show);
        show.setUpdatetime(new Date());
        showMapper.updateByPrimaryKeySelective(show);
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
}
