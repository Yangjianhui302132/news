package com.cloud.news.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class AuthFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //token（用户身份）判断
    	//................

        ServerHttpRequest req = exchange.getRequest().mutate()
                .header("from", "gateway").build();
        return chain.filter(exchange.mutate().request(req.mutate().build()).build());
    }
}
