package com.example.dxc.ClientHelloService.service;

import com.example.dxc.ClientHelloService.model.HelloModel;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientHelloService {

    private final RestTemplate restTemplate;

    public ClientHelloService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "helloHystrix")
    public HelloModel hello() {
        HelloModel helloObject = restTemplate.getForObject("http://hello-service/hello", HelloModel.class);
        return helloObject;
    }

    public HelloModel helloHystrix() {
        HelloModel helloObject = new HelloModel();
        helloObject.setMessage("Hello Circuit Breaker - Hystrix");
        return helloObject;
    }
  

}