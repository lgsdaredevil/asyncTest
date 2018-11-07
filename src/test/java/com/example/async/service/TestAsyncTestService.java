package com.example.async.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author gsliu
 * @date 2018-11-07 14:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAsyncTestService {
    private final Logger logger = LoggerFactory.getLogger(TestAsyncTestService.class);

    @Autowired
    AsyncTestService ansyncTestService;

    @Test
    public void testRequestAnsync(){
        String name = "测试1";
        logger.info("测试service， name={}", name);
        String result = ansyncTestService.requestAnsync(name);
        Assert.assertEquals(result, "hello " + name);

    }
}
