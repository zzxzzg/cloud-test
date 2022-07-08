package com.example.provider2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/provider")
@Slf4j
public class CustomController {

    @GetMapping("/config")
    @ResponseBody
    public String getConfig() {
        Entry entry = null;
        try {
            entry = SphU.entry("getConfig");
            return "config";
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
}
