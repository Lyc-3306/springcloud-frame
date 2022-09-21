package com.mate.openfeign.controller;

import com.mate.openfeign.feignclients.NacosExplainClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title: OpenFeignController
 * @Author lyc
 * @Date: 2022/9/17 18:46
 */
@RestController
@RequestMapping("/openFeignCon")
public class OpenFeignController {
    private static final Logger log = LoggerFactory.getLogger(OpenFeignController.class);

    @Autowired
    private NacosExplainClient nacosExplainClient;


    @GetMapping("/invoke")
    public String invokeProduct(@RequestParam int id){
        log.info("调用用户服务....");
        //openFeign
        String result="";
        result = nacosExplainClient.product(id);
        log.info("商品服务调用结果: {}",result);
        return  result;
    }

}
