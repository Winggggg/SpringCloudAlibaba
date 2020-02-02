package com.wing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/14 15:20
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping("/hello")
    public String hello(@RequestParam String name){
        log.info("hello "+name);
        return "hello "+name;
    }
}
