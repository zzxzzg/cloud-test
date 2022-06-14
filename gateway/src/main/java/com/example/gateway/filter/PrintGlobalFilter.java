package com.example.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class PrintGlobalFilter implements GlobalFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        System.out.println("PrintGlobalFilter::filter 前置处理 " + exchange.getResponse().getClass().getSimpleName());
        return chain.filter(exchange)
                .then(Mono.fromRunnable(() -> {
                    System.out.println("PrintGlobalFilter::filter 后置处理 " + exchange.getResponse().getClass().getSimpleName());
                }));
    }

}
