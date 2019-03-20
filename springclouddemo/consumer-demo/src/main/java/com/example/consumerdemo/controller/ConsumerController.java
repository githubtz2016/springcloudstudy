package com.example.consumerdemo.controller;

import com.example.consumerdemo.remote.ProviderRemote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    ProviderRemote providerRemote;

    @RequestMapping(value = "/getProvider")
    public String getProvider(){
        return providerRemote.getPort();
    }

}
