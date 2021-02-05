package com.yun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaojingang
 * @desc
 * @date 2021-02-03 19:22:31
 */
@SpringBootApplication
/**
 * 当前使用eureka的server
 * //@EnableEurekaClient 和 @EnableDiscoveryClient 都是让eureka发现该服务并注册到eureka上的注解
 * //相同点：都能让注册中心Eureka发现，并将该服务注册到注册中心上；
 * //不同点：@EnableEurekaClient只适用于Eureka作为注册中心，而@EnableDiscoveryClient可以是其他注册中心
 */
@EnableDiscoveryClient
public class EurekaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerApplication.class, args);
    }
}
