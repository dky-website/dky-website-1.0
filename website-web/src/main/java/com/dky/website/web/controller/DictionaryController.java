package com.dky.website.web.controller;

import com.dky.website.business.biz.DictionaryService;
import com.dky.website.common.bean.Dictionary;
import com.dky.website.common.response.ReturnT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wonpera on 2017/2/25.
 */
@RestController
@RequestMapping(value = "dic")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;


    @RequestMapping("getDicByType")
    public ReturnT<List<Dictionary>> getDicByType(@RequestParam(value = "dicType")String dicType){
        List<Dictionary> list = dictionaryService.queryDicList(dicType);
        return new ReturnT<>().sucessData(list);
    }
}
