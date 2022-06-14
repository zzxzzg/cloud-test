package com.example.provider1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CustomConfig {
    @Value("${lidong.test}")
    private String lidongTest;

}
