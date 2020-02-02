package com.wing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 15:37
 */
@RestController
@Slf4j
@RefreshScope
public class TestController {


    @Autowired
    LoadBalancerClient loadBalancerClient;


    @Value("${userName:wing}")
    private String userName;

    @GetMapping("/echo/{name}")
    public String test(@PathVariable("name") String name) {

        log.info("动态配置userName:{}",userName);

        // 通过spring cloud common中的负载均衡接口选取服务提供节点实现接口调用
        // serviceId为spring.application.name
        ServiceInstance serviceInstance = loadBalancerClient.choose("demo-producer");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "from: " + url + ",return: " + result;
    }

}
