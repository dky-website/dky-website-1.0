package com.dky.website.business.cache;

import com.google.common.cache.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 *
 * Created by wangpeng on 2017/1/6.
 */
public class LoadingCacheManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadingCacheManager.class);
    /**
     * 不需要延迟处理(泛型的方式封装)
     * @return
     */
    public static  <K , V> LoadingCache<K , V> cached(CacheLoader<K , V> cacheLoader) {
        LoadingCache<K , V> cache = CacheBuilder
                .newBuilder()
                .maximumSize(2)
                .weakKeys()
                .softValues()
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .removalListener(new RemovalListener<K, V>(){
                    @Override
                    public void onRemoval(RemovalNotification<K, V> rn) {
                        LOGGER.info(rn.getKey()+"被移除");

                    }})
                .build(cacheLoader);
        return cache;
    }

}
