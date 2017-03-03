package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;

import java.util.List;


/**
 * Created by hang on 2017/2/28.
 */
public class ShowPageView extends BaseParameter {

    private ShowView middleShow;

    private List<ShowView> oldShowList;

    public ShowView getMiddleShow() {
        return middleShow;
    }

    public void setMiddleShow(ShowView middleShow) {
        this.middleShow = middleShow;
    }

    public List<ShowView> getOldShowList() {
        return oldShowList;
    }

    public void setOldShowList(List<ShowView> oldShowList) {
        this.oldShowList = oldShowList;
    }
}
