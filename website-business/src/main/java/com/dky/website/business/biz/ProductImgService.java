package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.ProductImg;
import com.dky.website.common.param.AddProductImgParam;
import com.dky.website.common.param.QueryProductImgParam;
import com.dky.website.common.param.UpdProductImgParam;
import com.dky.website.common.response.ReturnT;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/27.
 */
public interface ProductImgService {

    PageHelper.Page<ProductImg> queryProductImgPage(QueryProductImgParam param);

    ReturnT<List<ProductImg>> queryProductImgList(QueryProductImgParam param);

    ReturnT addProductImg(AddProductImgParam param);

    ReturnT updateProductImg(UpdProductImgParam param);

    ReturnT deleteProductImg(Long id);

    ReturnT<ProductImg> getProductImgById(Long id);
}
