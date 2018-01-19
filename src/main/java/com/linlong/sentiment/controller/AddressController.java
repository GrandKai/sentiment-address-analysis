package com.linlong.sentiment.controller;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;
import com.linlong.core.bean.ResponseModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    @GetMapping("parse")
    public ResponseModel parse(@RequestParam String address) {
        ResponseModel result = new ResponseModel();
        // 测试 需要打开避免缓存
        CustomDictionary.reload();
        Segment segment = HanLP.newSegment().enableCustomDictionary(true).enableCustomDictionaryForcing(true);

        List<Term> list = segment.seg(address);
        result.setContent(list);

        return result;
    }
}
