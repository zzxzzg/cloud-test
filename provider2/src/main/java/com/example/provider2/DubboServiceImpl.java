package com.example.provider2;

import com.example.export.service.DubboService;

@org.apache.dubbo.config.annotation.DubboService(interfaceClass = DubboService.class, version = "1.0.0", timeout = 200)
public class DubboServiceImpl implements DubboService {
    @Override
    public String sayHello() {
        return "say hello";
    }
}
