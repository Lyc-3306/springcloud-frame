package com.mate.nacos.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: DemoController
 * @Author lyc
 * @Date: 2022/9/15 20:15
 */
@RestController
@RefreshScope //允许远端配置修改自动刷新
@RequestMapping("/nacosDemo")
public class DemoController {
    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    //@Value("${namea}") //(配置在nacos控制台里)
    private String username;
    @Value("${spring.profiles.active}")
    private String environment;
    @Value("${server.port}")
    private int port;

    @GetMapping("/demo")
    public String demo(){
        log.info("demo ok !!!");
        return "demo ok !!!,环境："+environment+" ，username:"+ username;
    }

    @GetMapping("/openFeignTest")
    public String product(Integer id) throws Exception {
        if(id<0){
            throw new Exception("失敗");
        }
        Thread.sleep(1200);
        return "商品服务返回: "+id+",当前提供服务端口为: "+port;
    }

}
