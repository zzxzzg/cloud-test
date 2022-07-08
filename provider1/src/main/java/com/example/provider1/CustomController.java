package com.example.provider1;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/provider")
@Slf4j
public class CustomController {
    @Resource
    private CustomConfig customConfig;

    @GetMapping("/config")
    @ResponseBody
    public String getConfig(HttpServletRequest request, HttpServletResponse response) {
        Entry entry = null;
        try {
            entry = SphU.entry("getConfig");
            log.warn(JSON.toJSONString(Provider1Switch.listSwitch));
            log.warn(JSON.toJSONString(Provider1Switch.mapSwitch));
            log.warn(JSON.toJSONString(Provider1Switch.longSwitch));
            log.warn(JSON.toJSONString(Provider1Switch.stringSwitch));
            return customConfig.getLidongTest();
        } catch (BlockException e1) {
            /*流控逻辑处理 - 开始*/
           return "block";
            /*流控逻辑处理 - 结束*/
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    @GetMapping("/trace")
    @ResponseBody
    public String getTrace() {
        return TraceContext.traceId();
    }
}
