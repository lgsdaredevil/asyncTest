package com.example.async.controller;

import com.example.async.service.AsyncTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author gsliu
 * @date 2018-07-16 16:50
 */
@RestController
public class AsyncTestController {

    @Autowired
    AsyncTestService ansyncTestService;

    @GetMapping("/{name}")
    public String test(@PathVariable String name){
        return ansyncTestService.requestAnsync(name);
    }

    @GetMapping("/n/{name}")
    public String noReturn(@PathVariable String name){
        return ansyncTestService.noReturn(name);
    }

    @GetMapping("/ng/{name}")
    public String noGet(@PathVariable String name){
        return ansyncTestService.noGet(name);
    }

}
