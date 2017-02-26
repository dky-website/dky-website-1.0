package com.dky.website.business.biz;

import com.dky.website.common.bean.Dictionary;
import com.dky.website.common.param.QueryDictionaryParam;

import java.util.List;

/**
 * Created by wonpera on 2017/2/25.
 */
public interface DictionaryService {

    List<Dictionary> queryDicList(String dicType);
}
