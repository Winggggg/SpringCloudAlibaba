package com.wing.config;

import com.wing.component.JwtTokenEnhancer;
import com.wing.service.CustomerUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heweiye
 * @version 1.0
 * @description 认证服务器配置
 * @date 2020/1/15 14:32
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("jwtTokenStore")
//    @Qualifier("redisTokenStore")
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenEnhancer tokenEnhancer;

    @Autowired
    private CustomerUserDetailsService userDetailsService;





    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        // 获取密钥需要身份认证，使用单点登录时必须配置
//        security.tokenKeyAccess("isAuthenticated()");

//        // 允许表单认证
        security.allowFormAuthenticationForClients();
    }


    /**
     * 用来配置客户端详情服务 客户端详情信息在这里进行初始化，
     * 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
     * 这里从内存中存储初始化客户端信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret(passwordEncoder.encode("admin123456"))
                .accessTokenValiditySeconds(3600)
                .refreshTokenValiditySeconds(864000)
                .redirectUris("http://www.baidu.com")
                .autoApprove(true)
                .scopes("all")
                .authorizedGrantTypes("authorization_code","password","refresh_token");

    }


    /**
     * 使用密码模式需要配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        token链式增强
        TokenEnhancerChain tokenEnhancerChain=new TokenEnhancerChain();
        List<TokenEnhancer> delegates=new ArrayList<>();
        delegates.add(tokenEnhancer);
        delegates.add(jwtAccessTokenConverter);
        tokenEnhancerChain.setTokenEnhancers(delegates);

//        配置属性及认证增强
        endpoints.tokenStore(tokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenEnhancer(tokenEnhancerChain);

//        endpoints.tokenStore(tokenStore)
//                .authenticationManager(authenticationManager)
//                .userDetailsService(userDetailsService)
//                .tokenEnhancer(tokenEnhancer);

    }

}
