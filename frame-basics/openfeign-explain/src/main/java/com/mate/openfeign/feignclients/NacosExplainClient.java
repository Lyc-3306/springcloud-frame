package com.mate.openfeign.feignclients;

import com.mate.openfeign.feignclients.fallback.NacosExplainImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * name为调用rest接口的服务名(spring.application.name)
 * path为调用rest接口的路径
 * Fallback是通过Hystrix实现的， 所以需要开启Hystrix，(未开启不能使用)
 * spring boot application.properties文件配置feign.hystrix.enabled=true，这样就开启了Fallback,否则不能使用
 */
@FeignClient(value = "nacos-explain",path = "/nacos-explain",
            fallback = NacosExplainImpl.class)
public interface NacosExplainClient {
    @GetMapping("/nacosDemo/openFeignTest")
    String product(@RequestParam("id") Integer id);

    /* 其他用法
    @PostMapping("/lycTest")
    Map<String,Object> lycTest(List<Product> product);

    @PostMapping("/lycTest")
    String lycTest(@RequestBody JSON body);

    @GetMapping("/lycTest")
    List<Product> lycTest(@RequestParam("name") String name,@RequestParam("id") Integer id);

    */
}
