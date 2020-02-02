package com.wing.feign;

import com.wing.bean.Jwt;
import com.wing.component.AuthServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author heweiye
 * @version 1.0
 * @description TODO
 * @date 2020/1/15 17:34
 */
@FeignClient(name ="authorization-server")
public interface IAuthorClient {

    /**
     * 获取token
     * @param type
     * @param username
     * @param password
     * @param scope
     * @param clientId
     * @param clientSecret
     * @return
     */
    @PostMapping(value = "/oauth/token")
    Jwt getToken(@RequestParam("grant_type") String type, @RequestParam("username") String username, @RequestParam("password") String password,
                 @RequestParam("scope") String scope,@RequestParam("client_id") String clientId,@RequestParam("client_secret") String clientSecret);

}
