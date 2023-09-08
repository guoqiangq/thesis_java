package com.springboot.controller;

import com.springboot.service.BrowseService;
import com.springboot.service.PublishService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.sql.Time;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "api/publish")
public class PublishController {
    @Autowired
    private PublishService publishService;
    @Autowired
    public BrowseService browse_service;

    @RequestMapping(value = "/addPublish",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addPublish(@RequestParam Map<String,Object> param){
        System.out.println("新增文宝:"+param);
        Map<String,Object> obj= publishService.addPublish(param);
        return obj;
    }
    @RequestMapping(value = "/removePublish",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> removePublish(@RequestParam Map<String,Object> param){
        Map<String,Object> obj= publishService.removePublish(param);
        return obj;
    }
    @RequestMapping(value = "/getPublish",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.getPublish(param);

        Map<String,Object> mapobj = new HashMap<String,Object>();
        if (obj.get("data") == null){
            return obj;
        }
        Object data_obj = obj.get("data");


        if (param.get("user_id")!=""&&param.get("user_id")!=null){
//            if (param.get("user_id") == data_obj.get("user_id")){
//                System.out.println("添加浏览记录失败:"+map);
//                return obj;
//            }
            mapobj.put("user_id",param.get("user_id"));
            mapobj.put("essay_id",param.get("id"));
            Map<String,Object> browse_obj= browse_service.addBrowse(mapobj);
            System.out.println("添加浏览记录:"+browse_obj);
        }


        return obj;
    }


    @RequestMapping(value = "/listPublish",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.listPublish(param);
        return obj;
    }
    @RequestMapping(value = "/listPublishAll",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listPublishAll(String name) {
        Map<String,Object> obj= publishService.listPublishAll(name);
        return obj;
    }
    @RequestMapping(value = "/listUnblackenPublishAll",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> listUnblackenPublishAll(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.listUnblackenPublishAll(param);
        return obj;
    }
    @RequestMapping(value = "/addCollectPublish",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addCollectPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.addCollectPublish(param);
        return obj;
    }
    @RequestMapping(value = "/addGiveLikePublish",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addGiveLikePublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.giveLikePublish(param);
        return obj;
    }
    @RequestMapping(value = "/addCommentPublish",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> addCommentPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.commentPublish(param);
        return obj;
    }
    @RequestMapping(value = "/getCommentListPublish",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getCommentListPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.getPublishCommentList(param);
        return obj;
    }
    @RequestMapping(value = "/collectUserListPublish",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> collectUserListPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.collectUserListPublish(param);
        return obj;
    }
    @RequestMapping(value = "/giveLikeUserListPublish",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> giveLikeUserListPublish(@RequestParam Map<String,Object> param) {
        Map<String,Object> obj= publishService.giveLikeUserListPublish(param);
        return obj;
    }
}
