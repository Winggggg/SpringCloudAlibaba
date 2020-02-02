package com.wing.config;

import com.wing.component.JwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author heweiye
 * @version 1.0
 * @description 使用jwt存储token的配置
 * @date 2020/1/15 14:03
 *
 * jwt存储内容格式如下
 *   {
 *   "user_name": "macro",
 *   "scope": [
 *     "all"
 *   ],
 *   "exp": 1572683821,
 *   "authorities": [
 *     "admin"
 *   ],
 *   "jti": "1ed1b0d8-f4ea-45a7-8375-211001a51a9e",
 *   "client_id": "admin",
 *   "enhance": "enhance info"
 * }
 *
 */
@Configuration
public class JwtTokenStoreConfig {


    @Bean
    public JwtTokenEnhancer jwtTokenEnhancer(){
        return new JwtTokenEnhancer();
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter jwtAccessTokenConverter=new JwtAccessTokenConverter();
        //设置jwt的秘钥
        jwtAccessTokenConverter.setSigningKey("admin123");
        return jwtAccessTokenConverter;
    }

    @Bean
    @Qualifier("jwtTokenStore")
    public JwtTokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

}
