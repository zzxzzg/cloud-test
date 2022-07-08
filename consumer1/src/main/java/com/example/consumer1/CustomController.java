package com.example.consumer1;

import com.example.export.service.DubboService;
import org.apache.dubbo.config.annotation.DubboReference;
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

    @Resource
    private RestTemplate restTemplate;

    @DubboReference(version = "1.0.0")
    private DubboService dubboService;


//    @GetMapping("/nacos")
//    @ResponseBody
//    public String nacosTest() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("provider1");
//        String server = serviceInstance.getHost()+":"+serviceInstance.getPort();
//
//        return new RestTemplate().getForObject("http://provider1/provider/config", String.class);
//    }

    @GetMapping("/nacos")
    @ResponseBody
    public String nacosTest() {
        return restTemplate.getForObject("http://provider1/provider/config", String.class);
    }

    @GetMapping("/dubbo")
    @ResponseBody
    public String dubboTest() {
        return dubboService.sayHello();
    }
}
