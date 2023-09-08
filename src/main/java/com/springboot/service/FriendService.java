package com.springboot.service;

import com.springboot.dao.FriendMappeer;
import com.springboot.dao.UserMappeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FriendService {
    @Autowired
    private FriendMappeer friend_mappeer;
    @Autowired
    private UserMappeer user_mappeer;
    public Map<String,Object> addFriend(@RequestParam Map<String,Object> param){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.put("status",1);
        param.put("time",sdf.format(System.currentTimeMillis()));
        param.put("status_time",sdf.format(System.currentTimeMillis()));
        int data = friend_mappeer.addFriend(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data != 1){
            obj.put("code",101);
            obj.put("message","添加失败!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> editFriend(@RequestParam Map<String,Object> param){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.put("status_time",sdf.format(System.currentTimeMillis()));
        int data = friend_mappeer.editFriend(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data != 1){
            obj.put("code",101);
            obj.put("message","修改失败!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> getIsStatusFriend(@RequestParam Map<String,Object> param){
        List<Map<String,Object>> data = friend_mappeer.getIsStatusFriend(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);

        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> removeFriend(@RequestParam Map<String,Object> param){
        int data = friend_mappeer.removeFriend(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data != 1){
            obj.put("code",101);
            obj.put("message","删除失败!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> getListFriend(@RequestParam Map<String,Object> param){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        List<Map<String,Object>> listMaps = friend_mappeer.getFriendList(param);
        if ( listMaps == null ){
            obj.put("code",1001);
            obj.put("message","数据未找到!");
            return obj;
        }

        for (Map<String, Object> map : listMaps) {
            Object id = map.get("friend_id");

            Map<String,Object> params = new HashMap<String,Object>();
            params.put("id",id);

            Map<String,Object> item_user = user_mappeer.getUserId(params);
            map.put("friend_name",item_user.get("user_name"));
            map.put("avatar",item_user.get("avatar"));
            map.put("email",item_user.get("email"));
            map.put("phone",item_user.get("phone"));
            map.put("gender",item_user.get("gender"));
            map.put("remark",item_user.get("remark"));
        }

        obj.put("data",listMaps);
        return obj;
    }
}
