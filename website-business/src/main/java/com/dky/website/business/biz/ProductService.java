package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.Product;
import com.dky.website.common.bean.ProductImg;
import com.dky.website.common.param.AddProductParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.UpdProductParam;
import com.dky.website.common.response.FrontProductView;
import com.dky.website.common.response.ReturnT;

import java.util.List;

/**
 * Created by wangpeng on 2017/2/27.
 */
public interface ProductService {

    PageHelper.Page<Product> queryProductPage(QueryProductParam param);

    ReturnT<List<Product>>  queryProductList(QueryProductParam param);

    ReturnT addProduct(AddProductParam param);

    ReturnT updateProduct(UpdProductParam param);

    ReturnT deleteProduct(Long param);

    ReturnT<Product> getProductById(Long id);

    ReturnT<FrontProductView> getFrontProductView(QueryProductParam param);

    ReturnT<List<FrontProductView>> getFrontProduct(QueryProductParam param);

    /**
     * 根据产品查询图片列表
     * @param param
     * @return
     */
    ReturnT<PageHelper.Page<ProductImg>> queryImgListByPage(QueryProductParam param);
}
