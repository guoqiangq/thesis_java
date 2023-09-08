package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.springboot.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/user")
public class UserController {
    @Autowired
    private  UserService user_service;

    @RequestMapping(value = "/getUsers",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUsers(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= user_service.getUsers(param);
        return obj;
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addUser(@RequestParam Map<String,Object> param){
        System.out.println(param);
        Map<String,Object> obj= user_service.addUser(param);
        return obj;
    }
    @RequestMapping(value = "/getUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getUser(@RequestParam Map<String,Object> param){
        System.out.println(param);
        Map<String,Object> obj= user_service.getUser(param);
        return obj;
    }
    @RequestMapping(value = "/findUser",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getUserFind(@RequestParam Map<String,Object> param){
        System.out.println(param);
        Map<String,Object> obj= user_service.getUserId(param);
        return obj;
    }
    @RequestMapping(value = "/editUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUser(@RequestParam Map<String,Object> param){
        System.out.println(param);
        Map<String,Object> obj= user_service.editUser(param);
        return obj;
    }
    @RequestMapping(value = "/editStatusUser",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editStatusUser(@RequestParam Map<String,Object> param){
        System.out.println("user_status"+param);
        Map<String,Object> obj= user_service.editStatusUser(param);
        return obj;
    }
    @RequestMapping(value = "/editUserPassword",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editUserPassword(@RequestParam Map<String,Object> param){
        System.out.println(param);
        Map<String,Object> obj= user_service.editUserPassword(param);
        return obj;
    }
}
