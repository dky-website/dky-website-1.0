package com.dky.website.common.base;

import com.dky.website.common.constats.GlobConts;

/**
 * Created by wonpera on 2017/2/18.
 */
public class WebPageParameter extends SessionParameter {


    private Integer requestOffset;
    private Integer requestCount;
    private Integer pageNo = 1;
    private Integer pageSize = GlobConts.DEFUALT_PAGE_SIZE;


    public Integer getRequestOffset() {
        return requestOffset;
    }

    public void setRequestOffset(Integer requestOffset) {
        this.requestOffset = requestOffset;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
