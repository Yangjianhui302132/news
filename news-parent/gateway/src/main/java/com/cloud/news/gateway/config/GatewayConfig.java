package com.cloud.news.gateway.config;

import com.cloud.news.gateway.filter.AuthFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public AuthFilter tokenFilter(){
        return new AuthFilter();
    }
}
