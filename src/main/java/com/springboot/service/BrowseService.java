package com.springboot.service;

import com.springboot.dao.BrowseMappeer;
import com.springboot.dao.PublishMappeer;
import com.springboot.dao.UserMappeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BrowseService {
    @Autowired
    public BrowseMappeer browse_mappeer;
    @Autowired
    public PublishMappeer publishMappeer;
    @Autowired
    public UserMappeer user_mappeer;

    public Map<String,Object> addBrowse(@RequestParam Map<String,Object> param){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.put("time",sdf.format(System.currentTimeMillis()));
        int data= browse_mappeer.addBrowse(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> removeBrowse(@RequestParam Map<String,Object> param){
        int data = browse_mappeer.removeBrowse(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        if (data != 1){
            obj.put("code",101);
            obj.put("message","删除失败!");
        }
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> getBrowseList(@RequestParam Map<String,Object> param){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        List<Map<String,Object>> listMaps = browse_mappeer.getBrowseList(param);

        if ( listMaps == null || listMaps.isEmpty()){
            obj.put("code",1001);
            obj.put("message","数据未找到!");
            return obj;
        }

        for (Map<String, Object> map : listMaps) {
            Object id = map.get("essay_id");

            Map<String,Object> params = new HashMap<String,Object>();
            params.put("id",id);
            params.put("essay_id",id);
            Map<String,Object> data_obj = publishMappeer.getPublish(params);
            if(data_obj != null){
                map.put("title",data_obj.get("title"));
                map.put("img",data_obj.get("img"));
                map.put("description",data_obj.get("description"));
                map.put("content",data_obj.get("content"));
                map.put("time",data_obj.get("time"));
                int item_maps = publishMappeer.getPublishDetailsCollectAll(params);
                int item_maps_giveLike = publishMappeer.getPublishDetailsGiveLikeAll(params);
                int item_maps_comment = publishMappeer.getPublishDetailsComment(params);

                map.put("is_collect",item_maps);
                map.put("is_like",item_maps_giveLike);
                map.put("comment",item_maps_comment);

                Map<String,Object> params_user = new HashMap<String,Object>();
                params_user.put("id",data_obj.get("user_id"));
                Map<String,Object> item_user = user_mappeer.getUserId(params_user);
                map.put("user_name",item_user.get("user_name"));
                map.put("avatar",item_user.get("avatar"));
            }


        }

        obj.put("data",listMaps);
        return obj;
    }
}
