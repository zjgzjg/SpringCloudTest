package com.yun;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaojingang
 * @desc 服务提供Controller
 * @date 2021-01-22 17:40:17
 */
@RestController
@RequestMapping("/Hello")
public class Controller {

    @RequestMapping("/World")
    public String helloWorld(String s) {
        System.out.println("传入的值为：" + s);
        return "传入的值为：" + s;
    }

}