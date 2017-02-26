package com.dky.website.business.biz.impl;

import com.dky.website.business.biz.DictionaryService;
import com.dky.website.business.mapper.DictionaryMapper;
import com.dky.website.common.bean.Dictionary;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 数据字典
 * Created by wonpera on 2017/2/25.
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryServiceImpl.class);

    @Autowired
    private DictionaryMapper dictionaryMapper;

    public static LoadingCache<String,List<Dictionary>> dictCahceBuilder;


    /**
     * 异步cache字典数据
     * @param cacheLoader
     * @return
     */
    public static synchronized LoadingCache<String,List<Dictionary>> getCacheBuilder(CacheLoader<String, List<Dictionary>> cacheLoader){
        dictCahceBuilder =  CacheBuilder
                .newBuilder()
                .refreshAfterWrite(5, TimeUnit.MINUTES)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .build(cacheLoader);
        return dictCahceBuilder;
    }


    /**
     * 根据类型获取数据字典
     * @param dicType
     * @return
     */
    @Override
    public List<Dictionary> queryDicList(String dicType) {
        try {
            if ((dictCahceBuilder != null) && (dictCahceBuilder.get(dicType) != null)){
                return dictCahceBuilder.get(dicType);
            }else {
                return getCacheBuilder(new CacheLoader<String, List<Dictionary>>() {
                    @Override
                    public List<Dictionary> load(String s) throws Exception {
                        Dictionary dictionary = new Dictionary();
                        dictionary.setDicType(s);
                        return dictionaryMapper.query(dictionary);
                    }
                }).get(dicType);
            }
        } catch (Exception e) {
            LOGGER.error("获取数据字典失败");
            return null;
        }
    }
}
