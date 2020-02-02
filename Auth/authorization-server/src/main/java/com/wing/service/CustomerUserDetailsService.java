package com.wing.service;

import com.wing.bean.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
 * @description 自定义实现安全框架提供的获取用户类
 * @date 2020/1/15 14:22
 */
@Service
public class CustomerUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private List<UserDetails> userDetailsList;

    @PostConstruct
    public void initData() {
        String password = passwordEncoder.encode("123456");
        userDetailsList = new ArrayList<>();
        userDetailsList.add(new CustomUserDetails(password,"wing", AuthorityUtils.commaSeparatedStringToAuthorityList("admin")));
        userDetailsList.add(new CustomUserDetails(password,"mike", AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
        userDetailsList.add(new CustomUserDetails(password,"test", AuthorityUtils.commaSeparatedStringToAuthorityList("client")));
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<UserDetails> list = userDetailsList.stream().filter(userDetails -> userDetails.getUsername().equals(userName)).collect(Collectors.toList());
        if (CollectionUtils.isEmpty(list)) {
            throw new UsernameNotFoundException("用户名密码错误");
        } else {
            return list.get(0);
        }
    }
}
