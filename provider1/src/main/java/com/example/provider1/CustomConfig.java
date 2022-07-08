package com.example.provider1;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import lombok.Data;

@Configuration
@Data
public class CustomConfig {

    @Value("${lidong.test}")
    private String lidongTest;

//    @Bean
//    public ConfigService createConfigService() {
//        Properties properties = new Properties();
//        properties.put("serverAddr", "http://127.0.0.1:8848");
//        properties.put("namespace", "f67be20f-2a3f-4fdd-93b1-3f160a78bca9");
//        try {
//            return NacosFactory.createConfigService(properties);
//        } catch (NacosException e) {
//            throw new RuntimeException(e);
//        }
//    }
}
