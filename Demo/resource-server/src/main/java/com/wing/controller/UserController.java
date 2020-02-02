package com.wing.controller;

import com.wing.bean.UserDto;
import com.wing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/15 16:05
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserDto login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
        return userService.login(userName, password);
    }
}
