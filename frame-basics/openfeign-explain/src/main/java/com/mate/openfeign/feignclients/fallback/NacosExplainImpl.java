package com.mate.openfeign.feignclients.fallback;

import com.mate.openfeign.feignclients.NacosExplainClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @title: NacosExplainImpl
 * @Author lyc
 * @Date: 2022/9/17 22:35
 */
@Component
@Slf4j
public class NacosExplainImpl implements NacosExplainClient {

    @Override
    public String product(Integer id) {
        //正常情况下会有封装的通用对象去返回
        log.error("调用失败");
        return "调用失败";
    }
}
