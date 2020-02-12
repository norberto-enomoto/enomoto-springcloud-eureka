package com.example.dxc.HelloService.controller;

import com.example.dxc.HelloService.model.HelloModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {
  private AtomicLong counter = new AtomicLong();

  @GetMapping("/hello")
  public HelloModel getHelloWordObject() {
      HelloModel hello = new HelloModel();
      hello.setMessage("Hi there! you are number " + counter.incrementAndGet());
      return hello;
  }
}