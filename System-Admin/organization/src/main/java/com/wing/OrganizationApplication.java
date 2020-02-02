package com.wing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 15:19
 */
@EnableDiscoveryClient
@SpringBootApplication
public class OrganizationApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(OrganizationApplication.class,args);
    }
}
