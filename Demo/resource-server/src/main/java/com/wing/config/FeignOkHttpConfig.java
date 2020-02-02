package com.wing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author heweiye
 * @version 1.0
 * @description feign okHttp配置
 * @date 2020/1/15 17:25
 */
@Configuration
public class FeignOkHttpConfig {

    private int feignOkHttpReadTimeout = 60;
    private int feignConnectTimeout = 60;
    private int feignWriteTimeout = 120;

    @Bean
    public okhttp3.OkHttpClient okHttpClient() {
        return new okhttp3.OkHttpClient.Builder()
                .readTimeout(feignOkHttpReadTimeout, TimeUnit.SECONDS)
                .connectTimeout(feignConnectTimeout, TimeUnit.SECONDS)
                .writeTimeout(feignWriteTimeout, TimeUnit.SECONDS)
//				.connectionPool(new ConnectionPool(int maxIdleConnections, long keepAliveDuration, TimeUnit timeUnit))   //自定义链接池
//                .addInterceptor()
                .build();
    }
}
