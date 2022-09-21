package com.mate.openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @title: OpenFeignApplication
 * @Author lyc
 * @Date: 2022/9/17 18:33
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class OpenFeignApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenFeignApplication.class,args);
    }
}
