package com.yun;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhaojingang
 * @desc
 * @date 2021-02-03 19:23:24
 */
@RestController
@RequestMapping("/Hello")
public class ConsumerController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/Consumer")
    public String helloWorld(String s) {
        System.out.println("传入的值为：" + s);
        //第一种调用方式，直接调用：不经过注册中心拿服务列表，直接访问的servicesupport
//        String forObject = new RestTemplate().getForObject("http://localhost:8071/Hello/World?s=" + s, String.class);
//        System.out.println(forObject);

        // 第二种调用方式
        // 根据服务名 获取服务列表 根据算法选取某个服务 并访问某个服务的网络位置。用服务名去注册中心获取服务列表，当前客户端底层会做随机算法的选取获得服务并访问。
        ServiceInstance serviceInstance = loadBalancerClient.choose("EUREKA-SERVICE");
        String forObject2 = new RestTemplate().getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/Hello/World?s=" + s, String.class);
        System.out.println(forObject2);

        //第三种调用方式 需要restTemplate注入的方式。第三种需要一个@Bean的注解自动注入并直接调用restTemplate对象调用服务。底层调用模式与第二种调用方式一样。
        String forObject3 = restTemplate.getForObject("http://EUREKA-SERVICE/Hello/World?s=" + s, String.class);
        System.out.println(forObject3);

        return forObject3;
    }
}
