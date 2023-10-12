package com.springboot.service;

import com.springboot.dao.FriendMappeer;
import com.springboot.dao.PublishMappeer;
import com.springboot.dao.UserMappeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PublishService {

    @Autowired
    public PublishMappeer publishMappeer;
    @Autowired
    public UserMappeer user_mappeer;
    @Autowired
    public FriendMappeer friend_mappeer;
    public Map<String,Object> addPublish(@RequestParam Map<String,Object> param){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.put("time",sdf.format(System.currentTimeMillis()));
        int data = publishMappeer.addPublish(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> removePublish(@RequestParam Map<String,Object> param){
        int data = publishMappeer.removePublish(param);

        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> listPublish(@RequestParam Map<String,Object> param){
        List<Map<String,Object>> data= publishMappeer.listPublish(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",data);
        return obj;
    }
    public Map<String,Object> listPublishAll(String name){
        List<Map<String,Object>> listMaps = publishMappeer.listPublishAll(name);
        for (Map<String, Object> map : listMaps) {
           Object id = map.get("id");

            Map<String,Object> params = new HashMap<String,Object>();
            params.put("essay_id",id);
            int item_maps = publishMappeer.getPublishDetailsCollectAll(params);
            int item_maps_giveLike = publishMappeer.getPublishDetailsGiveLikeAll(params);
            int item_maps_comment = publishMappeer.getPublishDetailsComment(params);
            map.put("is_collect",item_maps);
            map.put("is_like",item_maps_giveLike);
            map.put("comment",item_maps_comment);
            Map<String,Object> params_user = new HashMap<String,Object>();
            params_user.put("id",map.get("user_id"));
            Map<String,Object> item_user = user_mappeer.getUserId(params_user);
            map.put("user_name",item_user.get("user_name"));
            map.put("avatar",item_user.get("avatar"));
        }

        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",listMaps);
        return obj;
    }
    /*查询非黑名单的所有*/
    public Map<String,Object> listUnblackenPublishAll(@RequestParam Map<String,Object> param){
        param.put("status","-1");
        List<Map<String,Object>> listMaps = publishMappeer.listUnblackenPublishAll(param);
        for (Map<String, Object> map : listMaps) {
            Object id = map.get("id");

            Map<String,Object> params = new HashMap<String,Object>();
            params.put("essay_id",id);
            int item_maps = publishMappeer.getPublishDetailsCollectAll(params);
            int item_maps_giveLike = publishMappeer.getPublishDetailsGiveLikeAll(params);
            int item_maps_comment = publishMappeer.getPublishDetailsComment(params);
            map.put("is_collect",item_maps);
            map.put("is_like",item_maps_giveLike);
            map.put("comment",item_maps_comment);
            Map<String,Object> params_user = new HashMap<String,Object>();
            params_user.put("id",map.get("user_id"));
            Map<String,Object> item_user = user_mappeer.getUserId(params_user);
            map.put("user_name",item_user.get("user_name"));
            map.put("avatar",item_user.get("avatar"));
        }

        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",listMaps);
        return obj;
    }
    public Map<String,Object> getPublish(@RequestParam Map<String,Object> param){
        param.put("essay_id",param.get("id"));
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        Map<String,Object> data= publishMappeer.getPublish(param);
        if (data==null){
            obj.put("code",1001);
            obj.put("data",null);
            obj.put("message","数据未找到!");
            return obj;
        }
        int item_maps = publishMappeer.getPublishDetailsCollectAll(param);
        int item_maps_giveLike = publishMappeer.getPublishDetailsGiveLikeAll(param);
        int item_maps_comment = publishMappeer.getPublishDetailsComment(param);
        Map<String,Object> data_details = new HashMap<String,Object>();
        data_details.put("is_collect",item_maps);
        data_details.put("is_like",item_maps_giveLike);
        data_details.put("comment",item_maps_comment);


        Map<String,Object> dataobj = new HashMap<String,Object>();
        dataobj.put("data_details",data_details);
        dataobj.put("data_find",data);
        obj.put("data",dataobj);
        return obj;
    }
    /*收藏*/
    public Map<String,Object> addCollectPublish(@RequestParam Map<String,Object> param){
        Map<String,Object> data_details= publishMappeer.getPublishDetails(param);
        Object id = 0;
        if (data_details==null){
            int data = publishMappeer.addPublishDetails(param);

           Map<String,Object> details= publishMappeer.getPublishDetails(param);
            id = details.get("id");
        }else{
            id = data_details.get("id");
        }
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String,Object> item = new HashMap<String,Object>();
        item.put("id",id);
        item.put("is_collect",param.get("is_collect"));
        item.put("collect_time",sdf.format(System.currentTimeMillis()));
        int item_data = publishMappeer.collectPublish(item);

        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data","成功!");
        return obj;
    }
    /*点赞*/
    public Map<String,Object> giveLikePublish(@RequestParam Map<String,Object> param){

        Map<String,Object> data_details= publishMappeer.getPublishDetails(param);
        Object id = 0;

        if (data_details==null){
            int data = publishMappeer.addPublishDetails(param);

            Map<String,Object> details= publishMappeer.getPublishDetails(param);

            id = details.get("id");
        }else{
            id = data_details.get("id");
        }
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Map<String,Object> item = new HashMap<String,Object>();
        item.put("id",id);
        item.put("is_like",param.get("is_like"));
        item.put("like_time",sdf.format(System.currentTimeMillis()));
        int item_data = publishMappeer.giveLikePublish(item);

        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data","成功!");
        return obj;
    }
    /*评论*/
    public Map<String,Object> commentPublish(@RequestParam Map<String,Object> param){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        param.put("time",sdf.format(System.currentTimeMillis()));
        param.put("content",param.get("comment"));
        param.put("status",1);
        int data = publishMappeer.addPublishComment(param);
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        obj.put("data",data);
        return obj;
    }
    /*获取评列表*/
    public Map<String,Object> getPublishCommentList(@RequestParam Map<String,Object> param){
        param.put("essay_id",param.get("id"));
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        List<Map<String,Object>> listMaps= publishMappeer.commentListPublish(param);
        if ( listMaps == null ){
            obj.put("code",1001);
            obj.put("message","数据未找到!");
            return obj;
        }

        for (Map<String, Object> map : listMaps) {
            Object id = map.get("user_id");
            map.put("is_friend",0);
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("id",id);
            params.put("friend_id",id);
            params.put("user_id",param.get("user_id"));
            Map<String,Object> item_user = user_mappeer.getUserId(params);
            map.put("user_name",item_user.get("user_name"));
            map.put("avatar",item_user.get("avatar"));

            if ( param.get("user_id")!="" && (param.get("user_id")!=id)){
                Map<String,Object> item_friend = friend_mappeer.getIsFriend(params);
                if (item_friend != null){
                    map.put("is_friend",1);
                }
            }
        }
        obj.put("data",listMaps);
        return obj;
    }
    public Map<String,Object> collectUserListPublish(@RequestParam Map<String,Object> param){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        List<Map<String,Object>> listMaps = publishMappeer.collectUserListPublish(param);

        if ( listMaps == null ){
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
            int item_maps = publishMappeer.getPublishDetailsCollectAll(params);
            int item_maps_giveLike = publishMappeer.getPublishDetailsGiveLikeAll(params);
            int item_maps_comment = publishMappeer.getPublishDetailsComment(params);
            map.put("title",data_obj.get("title"));
            map.put("img",data_obj.get("img"));
            map.put("description",data_obj.get("description"));
            map.put("content",data_obj.get("content"));
            map.put("time",data_obj.get("time"));
            map.put("is_collect",item_maps);
            map.put("is_like",item_maps_giveLike);
            map.put("comment",item_maps_comment);
            Map<String,Object> params_user = new HashMap<String,Object>();
            params_user.put("id",data_obj.get("user_id"));
            Map<String,Object> item_user = user_mappeer.getUserId(params_user);
            map.put("user_name",item_user.get("user_name"));
            map.put("avatar",item_user.get("avatar"));
        }

        obj.put("data",listMaps);
        return obj;
    }
    public Map<String,Object> giveLikeUserListPublish(@RequestParam Map<String,Object> param){
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code",0);
        List<Map<String,Object>> listMaps = publishMappeer.giveLikeUserListPublish(param);

        if ( listMaps == null ){
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
            int item_maps = publishMappeer.getPublishDetailsCollectAll(params);
            int item_maps_giveLike = publishMappeer.getPublishDetailsGiveLikeAll(params);
            int item_maps_comment = publishMappeer.getPublishDetailsComment(params);
            map.put("title",data_obj.get("title"));
            map.put("img",data_obj.get("img"));
            map.put("description",data_obj.get("description"));
            map.put("content",data_obj.get("content"));
            map.put("time",data_obj.get("time"));
            map.put("is_collect",item_maps);
            map.put("is_like",item_maps_giveLike);
            map.put("comment",item_maps_comment);
            Map<String,Object> params_user = new HashMap<String,Object>();
            params_user.put("id",data_obj.get("user_id"));
            Map<String,Object> item_user = user_mappeer.getUserId(params_user);
            map.put("user_name",item_user.get("user_name"));
            map.put("avatar",item_user.get("avatar"));
        }

        obj.put("data",listMaps);
        return obj;
    }
}
