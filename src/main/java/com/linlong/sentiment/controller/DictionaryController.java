package com.linlong.sentiment.controller;

import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.linlong.core.bean.ResponseModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/12/18.
 */
@RestController
public class DictionaryController {

    /**
     * 自定义字典重载
     * @return Result
     */
    @RequestMapping("dictionary/reload")
    public ResponseModel reloadDictionary(){
        CustomDictionary.reload();
        return new ResponseModel("自定义字典重载完成");
    }

}
