package com.example.consumerdemo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "provider-demo",fallback = ProviderHystrix.class)
public interface ProviderRemote {

    @RequestMapping(value = "/get")
    String getPort();
}
