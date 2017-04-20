package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.ProductImgList;
import com.dky.website.common.param.AddProductImgListParam;
import com.dky.website.common.param.QueryProductImgListParam;
import com.dky.website.common.param.UpdProductImgListParam;
import com.dky.website.common.response.ReturnT;
import java.util.List;

/**
 * Created by wangpeng on 2017/4/20.
 */
public interface ProductImgListService {

    PageHelper.Page<ProductImgList> queryPage(QueryProductImgListParam param);

    ReturnT<List<ProductImgList>> queryList(QueryProductImgListParam param);

    ReturnT addImgList(AddProductImgListParam param);

    ReturnT updImgList(UpdProductImgListParam param);

    ReturnT deleteImgList(Long id);

    ReturnT<ProductImgList> geteImgListById(Long id);
}
