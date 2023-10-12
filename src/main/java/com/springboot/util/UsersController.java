package com.springboot.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/user")
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method = {RequestMethod.GET,RequestMethod.POST})
    public Map<String,Object> login(@RequestParam Map<String,Object> param){

        Map<String,Object> map=new HashMap<>();
        map.put("code",1001);
        if(StringUtils.isEmpty(param.get("login_name").toString())||StringUtils.isEmpty(param.get("password").toString())){
            map.put("msg","用户或密码为空！");
            return map;
        }
        Map<String,Object> user1= userService.getUser(param);

        if((int)user1.get("code")==0){

          String token= TokenUtil.generateToken(user1.get("data"));
            user1.put("token",token);
        }
        return user1;
    }
}
