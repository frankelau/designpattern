package com.blink.web.logic;

import com.blink.web.bean.ResultEnum;
import com.blink.web.bean.WebConstants;
import com.blink.web.interfaces.ILogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 测试Logic
 */
@Service
public class TestLogic implements ILogic<Map<String, String>> {
    private Logger logger = LoggerFactory.getLogger("TestLogic");

    @Override
    public ResultEnum exec(Map<String, String> map) {
        logger.info("TestLogic.exec---------start,map:{}", map);
        map.put("name", "liuzhao");
        map.put("age", "11");
        map.put("sex", "male");
        map.put("resCode", WebConstants.Result.SUCCESS);
        map.put("resDesc", "成功");
        logger.info("TestLogic.exec---------end,map:{}", map);
        return ResultEnum.ParseOk;
    }
}
