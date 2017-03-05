package com.dky.website.business.biz;

import com.dky.website.business.plugin.PageHelper;
import com.dky.website.common.bean.FrontMenu;
import com.dky.website.common.param.AddFrountMenuParam;
import com.dky.website.common.param.QueryFrontMenuParam;
import com.dky.website.common.param.QueryProductParam;
import com.dky.website.common.param.UpdFrontMenuParam;
import com.dky.website.common.response.FrontMenuView;
import com.dky.website.common.response.ProductTypeView;
import com.dky.website.common.response.ReturnT;

import java.util.List;

/**
 * Created by wonpera on 2017/2/25.
 */
public interface FrontMenuService {

    PageHelper.Page<FrontMenu> queryFMenuPage(QueryFrontMenuParam param);


    ReturnT<List<FrontMenu>> queryFMenuList(QueryFrontMenuParam param);

    ReturnT addFMenu(AddFrountMenuParam param);

    ReturnT updateFMenu(UpdFrontMenuParam param);

    ReturnT deleteFMenu(Long id);

    ReturnT<FrontMenu> getFMenuById(Long id);

    List<FrontMenu> getProductTypeWithOutChoice();

    ReturnT<List<FrontMenuView>> getFrontMenuView(QueryFrontMenuParam param);

    ReturnT<List<ProductTypeView>> getProductTypeView(QueryProductParam param);
}
