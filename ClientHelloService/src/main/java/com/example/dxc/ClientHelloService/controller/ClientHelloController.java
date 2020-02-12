package com.example.dxc.ClientHelloService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

import com.example.dxc.ClientHelloService.model.HelloModel;
import com.example.dxc.ClientHelloService.service.ClientHelloService;

@EnableCircuitBreaker
@RestController
public class ClientHelloController {
    @Autowired
    private ClientHelloService clientHelloService;

    @RequestMapping("/hello")
    public HelloModel hello() {
        return clientHelloService.hello();
    }   
    
}