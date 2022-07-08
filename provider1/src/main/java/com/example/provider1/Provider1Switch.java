package com.example.provider1;

import com.alibaba.nacos.api.exception.NacosException;
import com.guardz.nacos.config.base.sw.NacosSwitch;
import com.guardz.nacos.config.base.sw.NacosSwitchConfig;
import com.guardz.nacos.config.base.sw.NacosSwitchManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NacosSwitchConfig
@Component
public class Provider1Switch {

    @Resource
    private NacosSwitchManager nacosSwitchManager;

    @PostConstruct
    public void init(){
        try {
            nacosSwitchManager.register(this.getClass());
        } catch (NacosException e) {
            throw new RuntimeException(e);
        }
    }

    @NacosSwitch
    public static Map<String, String> mapSwitch = new HashMap<>();

    @NacosSwitch
    public static List<String> listSwitch = new ArrayList<>();

    @NacosSwitch
    public static String stringSwitch = "123";

    @NacosSwitch
    public static long longSwitch = 12L;

}
