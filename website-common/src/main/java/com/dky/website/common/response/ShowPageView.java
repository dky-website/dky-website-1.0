package com.dky.website.common.response;

import com.dky.website.common.base.BaseParameter;

import java.util.List;


/**
 * Created by hang on 2017/2/28.
 */
public class ShowPageView extends BaseParameter {

    private List<ShowView> middleShowList;

    private List<ShowView> oldShowList;

    public List<ShowView> getMiddleShowList() {
        return middleShowList;
    }

    public void setMiddleShowList(List<ShowView> middleShowList) {
        this.middleShowList = middleShowList;
    }

    public List<ShowView> getOldShowList() {
        return oldShowList;
    }

    public void setOldShowList(List<ShowView> oldShowList) {
        this.oldShowList = oldShowList;
    }
}
