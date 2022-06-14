package com.example.consumer1;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;


@RestController
@RequestMapping("/consumer")
public class CustomController {

    @Resource
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/nacos")
    @ResponseBody
    public String nacosTest() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("provider1");
        String server = serviceInstance.getHost()+":"+serviceInstance.getPort();

        return new RestTemplate().getForObject("http://"+server+"/provider/config", String.class);
    }
}
