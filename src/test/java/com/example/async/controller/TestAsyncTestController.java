package com.example.async.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author gsliu
 * @date 2018-11-07 13:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestAsyncTestController {
    private final Logger logger = LoggerFactory.getLogger(TestAsyncTestController.class);

    @Autowired
    private MockMvc mvc;

    @Test
    public void controllerTest() throws Exception{
        String name = "测试";
        logger.info("测试内容：name={}", name);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/{}", name)
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andReturn();
        logger.info(mvcResult.getResponse().getHeader("status"));

    }

}
