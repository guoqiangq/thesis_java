package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PublishMappeer {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int addPublish(@RequestParam Map<String,Object> param) {
        String sql = "insert into publish (title,description,img,content,user_id,time) values (?,?,?,?,?,?)";//SQL查询语句
        int result = jdbcTemplate.update(sql,param.get("title"),param.get("description"),param.get("img"),param.get("content"),param.get("user_id"),param.get("time"));
        return result;
    }
    public int removePublish(@RequestParam Map<String,Object> param) {
        String sql = "delete from publish where id=?";//SQL删除语句
        int result = jdbcTemplate.update(sql, param.get("id"));
        return result;
    }
    public List<Map<String,Object>> listPublish(@RequestParam Map<String,Object> param) {
        String sql = "select * from publish where user_id = ?";
        Object[] obj = new Object[]{param.get("user_id")};
        if(!(param.get("title") ==null||param.get("title")=="")) {
            sql = "select * from publish where title like '%' ? '%' and user_id = ?";
            obj = new Object[]{param.get("title"),param.get("user_id")};
        }
        try {
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,obj);
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
    public Map<String,Object> getPublish(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from publish where id = ?";//SQL查询语句
            Map<String, Object> mapObj = jdbcTemplate.queryForMap(sql, param.get("id"));
            return mapObj;
        }
        catch (Exception e){
            return null;
        }

    }
    public Map<String,Object> getPublishDetails(@RequestParam Map<String,Object> param) {
        System.out.println("dao:"+param);
        try {
            String sql = "select * from publish_details where user_id = ? and essay_id = ?";//SQL查询语句
            Map<String, Object> mapObj = jdbcTemplate.queryForMap(sql, param.get("user_id"),param.get("essay_id"));
            System.out.println("dao_mapObj:"+mapObj);
            return mapObj;
        }
        catch (Exception e){
            System.out.println("抛错:"+e);
            return null;
        }

    }
    public List<Map<String,Object>> getPublishDetailsAll(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from publish_details where essay_id =?";//SQL查询语句
            List<Map<String, Object>> mapObj = jdbcTemplate.queryForList(sql, param.get("essay_id"));
            return mapObj;
        }
        catch (Exception e){
            return new ArrayList<>();
        }

    }
    public int getPublishDetailsCollectAll(@RequestParam Map<String,Object> param) {
        String sql = "SELECT COUNT(*) FROM publish_details WHERE is_collect = ? and essay_id =?";//SQL查询语句
        int result = jdbcTemplate.queryForObject(sql, Integer.class,1,param.get("essay_id"));
        return result;
    }
    public int getPublishDetailsGiveLikeAll(@RequestParam Map<String,Object> param) {
        String sql = "SELECT COUNT(*) FROM publish_details WHERE is_like = ? and essay_id =?";//SQL查询语句
        int result = jdbcTemplate.queryForObject(sql, Integer.class,1,param.get("essay_id"));
        return result;
    }
    public int getPublishDetailsComment(@RequestParam Map<String,Object> param) {
        String sql = "SELECT COUNT(*) FROM comment WHERE content != ? and essay_id =?";//SQL查询语句
        int result = jdbcTemplate.queryForObject(sql, Integer.class,"",param.get("essay_id"));
        return result;
    }
    public List<Map<String,Object>> listPublishAll(String name) {
        System.out.println(name);
        String sql = "select * from publish";//SQL查询语句
        Object[] obj = new Object[]{};
        if(!(name ==null||name=="")) {
            System.out.println("周期name");
           // System.out.println(new String(name.getBytes(),"utf-8"));
            sql = "select * from publish where title like '%' ? '%'";
           obj = new Object[]{name};
        }
        try {
//            String sql = "select * from publish";//SQL查询语句new Object[]{"1",param.get("user_id")}
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,obj);
            return list;
        }
        catch (Exception e){
            System.out.println("cccc:"+e);
            return new ArrayList<>();
        }
    }
    public List<Map<String,Object>> listUnblackenPublishAll(@RequestParam Map<String,Object> param) {
        System.out.println(param);
        String sql = "select * from publish where user_id not in( select friend_id from friend where status=? and user_id = ? )";//SQL查询语句
        Object[] obj = new Object[]{param.get("status"),param.get("user_id")};
        if(!(param.get("name") ==null||param.get("name")=="")) {
            sql = "select * from publish where title like '%' ? '%' and user_id not in( select friend_id from friend where status=? and user_id = ? )";
            obj = new Object[]{param.get("name"),param.get("status"),param.get("user_id")};
        }
        try {
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,obj);
            return list;
        }
        catch (Exception e){
            System.out.println("cccc:"+e);
            return new ArrayList<>();
        }
    }
    public int addPublishDetails(@RequestParam Map<String,Object> param) {
        String sql = "insert into publish_details (user_id,essay_id) values (?,?)";//SQL添加语句
        int result = jdbcTemplate.update(sql,param.get("user_id"),param.get("essay_id"));

        return result;
    }
    public int addPublishComment(@RequestParam Map<String,Object> param) {
        String sql = "insert into comment (user_id,essay_id,content,time,status) values (?,?,?,?,?)";//SQL添加语句
        int result = jdbcTemplate.update(sql,param.get("user_id"),param.get("essay_id"),param.get("content"),param.get("time"),param.get("status"));

        return result;
    }
    public int collectPublish(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE publish_details SET is_collect = ?,collect_time = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{param.get("is_collect"),param.get("collect_time"),param.get("id")});
        return result;
    }
    public int giveLikePublish(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE publish_details SET is_like = ?,like_time = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{param.get("is_like"),param.get("like_time"),param.get("id")});
        return result;
    }
    public int commentStatusPublish(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE comment SET status = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{param.get("status"),param.get("id")});
        return result;
    }
    public List<Map<String,Object>> commentListPublish(@RequestParam Map<String,Object> param) {
        try {
//            String sql = "select * from publish where ( title =? or title='' ) and user_id = ?";//SQL查询语句
            String sql = "select * from comment where essay_id = ?";//SQL查询语句
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,param.get("essay_id"));
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
    public List<Map<String,Object>> collectUserListPublish(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from publish_details where  is_collect = ?and user_id = ?";//SQL查询语句
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new Object[]{"1",param.get("user_id")});
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
    public List<Map<String,Object>> giveLikeUserListPublish(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from publish_details where  is_like = ?and user_id = ?";//SQL查询语句
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,new Object[]{"1",param.get("user_id")});
            System.out.println(list);
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
}
