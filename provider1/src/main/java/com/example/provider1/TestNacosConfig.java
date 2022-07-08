package com.example.provider1;

import com.guardz.nacos.config.AbstractSpringNacosConfig;
import com.guardz.nacos.config.NacosConfig;

@NacosConfig
public class TestNacosConfig extends AbstractSpringNacosConfig {

    @Override
    public String getGroup() {
        return "payment";
    }

    @Override
    public String getDataId() {
        return "white_list";
    }

    @Override
    public void configChange(String configSourceValue) {
        System.out.println(configSourceValue);
    }
}
