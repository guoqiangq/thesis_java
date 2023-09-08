package com.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/test")
public class TestController {
    @RequestMapping(value = "/demo")
    public void demo(){
        System.out.println("1111111~");
    }
    @RequestMapping(value = "/demo111")
    public void demo111(){
        System.out.println("22222~");
    }
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    @ResponseBody
    public String sayHello(){
        return "Hello, World!";
    }

}

