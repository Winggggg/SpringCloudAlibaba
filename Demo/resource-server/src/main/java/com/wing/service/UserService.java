package com.wing.service;

import com.wing.bean.Jwt;
import com.wing.bean.UserDto;
import com.wing.feign.IAuthorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/15 17:53
 */
@Service
public class UserService {


    private List<UserDto> userDetailsList;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IAuthorClient authorClient;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userDetailsList = new ArrayList<>();
        userDetailsList.add(new UserDto(password, "wing", null));
        userDetailsList.add(new UserDto(password, "mike", null));
        userDetailsList.add(new UserDto(password, "test", null));
    }

    public UserDto login(String userName, String password) {
        String encode = passwordEncoder.encode(password);
        List<UserDto> list = userDetailsList.stream().filter(userDto -> userName.equals(userDto.getUserName())).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(list)) {
            throw new RuntimeException("用户名密码error");
        }
        Jwt jwt = authorClient.getToken("password", userName, password, "all", "admin", "admin123456");
        UserDto userDto = list.get(0);
        userDto.setJwt(jwt);
        return userDto;
    }
}
