package com.wing.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @author heweiye
 * @version 1.0
 * @description 自定义实现安全框架提供的用户类
 * @date 2020/1/15 14:15
 */
public class CustomUserDetails implements UserDetails {

    private String password;
    private String userName;
    private List<GrantedAuthority> grantedAuthorities;


    public CustomUserDetails(String password, String userName, List<GrantedAuthority> grantedAuthorities) {
        this.password = password;
        this.userName = userName;
        this.grantedAuthorities = grantedAuthorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
