package com.yun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaojingang
 * @desc
 * @date 2021-01-22 17:54:16
 */
@SpringBootApplication
/**
 * 代表自己是一个服务提供方
 */
@EnableDiscoveryClient
public class EurekaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceApplication.class, args);
    }

}
