package com.springboot.service;

import com.springboot.dao.UserMappeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMappeer userMappeer;
    public Map<String,Object> getUsers(@RequestParam Map<String,Object> param){
        List<Map<String,Object>> list= userMappeer.getUsers(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",list);
        return obj;
    }
    public Map<String,Object> addUser(@RequestParam Map<String,Object> param){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.put("time",sdf.format(System.currentTimeMillis()));
        param.put("status",'1');
        Map<String,Object> data= userMappeer.addUser(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> getUser(@RequestParam Map<String,Object> param){
        Map<String,Object> data= userMappeer.getUser(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data==null){
            obj.put("code",1001);
            obj.put("message","登录账号/密码错误!");
        }

        if("-1".equals(data.get("status")+"")){
            obj.put("code",1002);
            obj.put("message","用户账号禁用!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> getUserId(@RequestParam Map<String,Object> param){
        Map<String,Object> data= userMappeer.getUserId(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data==null){
            obj.put("code",1001);
            obj.put("message","无此用户!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> editUser(@RequestParam Map<String,Object> param){
        int data = userMappeer.editUser(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data!=1){
            obj.put("code",1002);
            obj.put("message","用户信息修改失败!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> editStatusUser(@RequestParam Map<String,Object> param){
        int data = userMappeer.editStatusUser(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data!=1){
            obj.put("code",1002);
            obj.put("message","用户信息修改失败!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> editUserPassword(@RequestParam Map<String,Object> param){
        int data = userMappeer.editUserPassword(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data!=1){
            obj.put("code",1002);
            obj.put("message","用户密码修改失败!");
        }
        obj.put("data",data);
        return obj;
    }
}
