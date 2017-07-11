package com.blink.web.biz;

import com.blink.web.bean.ResultEnum;
import com.blink.web.bean.WebConstants;
import com.blink.web.interfaces.ILogic;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class TestBiz {
    private Logger logger = LoggerFactory.getLogger("TestBiz");
    @Resource
    private ILogic<Map<String, String>> testLogic;


    public Map<String, String> test(String queryId) {
        logger.info("TestBiz.test---------start,queryId:{}", queryId);
        HashMap<String, String> map = Maps.newHashMap();
        map.put("id", queryId);
        if (ResultEnum.ParseOk != testLogic.exec(map)) {
            map.put("resCode", WebConstants.Result.FAIL);
            map.put("resDesc", "失败");
        }
        return map;
    }
}
