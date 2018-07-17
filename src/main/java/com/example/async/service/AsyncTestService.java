package com.example.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @author gsliu
 * @date 2018-07-16 16:51
 */
@Service
public class AsyncTestService {
    private final Logger logger = LoggerFactory.getLogger(AsyncTestService.class);

    @Autowired
    AsyncTest asyncTest;


    public String requestAnsync(String name){
        try {
            Long start = System.currentTimeMillis();
            Future<String> result = asyncTest.ansync(name);
            if (result.isDone()){
                name = result.get();
                logger.info("异步方法结束，名字改为：" + name);
            }
            Long end = System.currentTimeMillis();
            logger.info("耗时：" + (int)(end-start));
            return "hello " + name;
        }catch (Exception e){
            logger.error("异常");
            return "异常";
        }
    }

    public String noReturn(String name){
        Long start = System.currentTimeMillis();
//        noReturnAsync(name);
        asyncTest.noReturnAsync(name);
        Long end = System.currentTimeMillis();
        logger.info("耗时：" + (int)(end-start));
        return "hello " + name;
    }

    public String noGet(String name){
        Long start = System.currentTimeMillis();
        ansync(name);
        Long end = System.currentTimeMillis();
        logger.info("耗时：" + (int)(end-start));
        return "hello " + name;
    }

//    @Async
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

//    @Async
    public void noReturnAsync(String name){
        try {
            Thread.sleep(10000);
            logger.info("这里是异步方法");
            logger.info("传过来的名字是：" + name);
            name = "修改的名字";
            logger.info("修改后的名字是：" + name);
        }catch (Exception e){
        }
    }

}
