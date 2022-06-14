package com.example.provider1;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/provider")
public class CustomController {
    @Resource
    private CustomConfig customConfig;

    @GetMapping("/config")
    @ResponseBody
    public String getConfig() {
        return customConfig.getLidongTest();
    }
}
