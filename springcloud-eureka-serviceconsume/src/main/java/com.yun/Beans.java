package com.yun;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhaojingang
 * @desc
 * @date 2021-02-03 19:31:50
 */
@Configuration
public class Beans {

    /**
     * 管理简单对象
     */
    @Bean// 告诉工厂这个方法需要自动注入
    @LoadBalanced// 表示需要做负载匀衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
