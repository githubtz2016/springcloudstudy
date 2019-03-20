package com.example.consumerdemo.remote;

import org.springframework.stereotype.Component;

@Component
public class ProviderHystrix implements ProviderRemote {
    @Override
    public String getPort() {
        return "Provider is error";
    }
}
