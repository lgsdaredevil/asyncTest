package com.example.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author gsliu
 * @date 2018-07-17 9:46
 */
@Component
public class AsyncTest {
    private final Logger logger = LoggerFactory.getLogger(AsyncTest.class);

    @Autowired
    AsyncTestService asyncTestService;

    @Async
    public Future<String> ansync(String name){
        try {
            Thread.sleep(10000);
            logger.info("这里是异步方法");
            logger.info("传过来的名字是：" + name);
            name = "修改的名字";
            logger.info("修改后的名字是：" + name);
            return new AsyncResult<>("name: " + name);
        }catch (Exception e){
            return new AsyncResult<>("异常");
        }
    }

    @Async
    public void noReturnAsync(String name){
        try {
            asyncTestService.noReturnAsync(name);
//            Thread.sleep(10000);
//            logger.info("这里是异步方法");
//            logger.info("传过来的名字是：" + name);
//            name = "修改的名字";
//            logger.info("修改后的名字是：" + name);
        }catch (Exception e){
        }
    }

}
