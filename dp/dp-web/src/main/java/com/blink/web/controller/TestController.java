package com.blink.web.controller;

import com.blink.web.biz.TestBiz;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("test")
@Controller
public class TestController {
    private Logger logger = LoggerFactory.getLogger("TestController");
    @Resource
    private TestBiz testBiz;

    @RequestMapping("test")
    @ResponseBody
    public Map<String, String> test() {
        logger.info("TestController.test--------------start--");
        return testBiz.test("01");
    }
}
