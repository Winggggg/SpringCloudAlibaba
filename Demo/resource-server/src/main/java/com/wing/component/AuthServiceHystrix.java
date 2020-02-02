package com.wing.component;

import com.wing.bean.Jwt;
import com.wing.feign.IAuthorClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author heweiye
 * @version 1.0
 * @description 认证服务熔断
 * @date 2020/1/15 17:37
 */
@Component
@Slf4j
public class AuthServiceHystrix implements IAuthorClient {


    @Override
    public Jwt getToken(String type, String username, String password, String scope, String clientId, String clientSecret) {
        log.error("请求token失败");
        return new Jwt();
    }
}
