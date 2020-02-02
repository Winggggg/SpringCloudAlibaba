package com.wing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/16 9:02
 */
@RestController
public class ResourceController {


    @GetMapping("/test")
    public String test(){
        return "test oauth token";
    }

}
