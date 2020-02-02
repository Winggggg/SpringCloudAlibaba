package com.wing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author heweiye
 * @version 1.0
 * @description 自定义实现安全框架提供的用户类
 * @date 2020/1/15 14:15
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ResourceServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResourceServerApplication.class, args);
    }
}
