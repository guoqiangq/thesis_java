package com.springboot.controller;

import com.springboot.service.BrowseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Map;

@RestController
@RequestMapping(value = "api/browse")
public class BrowseController {

    @Autowired
    public BrowseService browse_service;
    @RequestMapping(value = "/addBrowse",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addBrowse(@RequestParam Map<String,Object> param){
        System.out.println(param);
        Map<String,Object> obj= browse_service.addBrowse(param);

        return obj;
    }
    @RequestMapping(value = "/removeBrowse",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> removeBrowse(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= browse_service.removeBrowse(param);
        return obj;
    }
    @RequestMapping(value = "/getBrowseList",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBrowseList(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= browse_service.getBrowseList(param);
        return obj;
    }
}
