package com.springboot.controller;

import com.springboot.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "api/friend")
public class FriendController {
    @Autowired
    private FriendService friend_service;
    @RequestMapping(value = "/addFriend",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addFriend(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= friend_service.addFriend(param);
        return obj;
    }
    @RequestMapping(value = "/editFriend",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> editFriend(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= friend_service.editFriend(param);
        return obj;
    }
    @RequestMapping(value = "/removeFriend",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> removeFriend(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= friend_service.removeFriend(param);
        return obj;
    }
    @RequestMapping(value = "/getListFriend",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getListFriend(@RequestParam Map<String,Object> param){
//        System.out.println(param);
        Map<String,Object> obj= friend_service.getListFriend(param);
        return obj;
    }

}
