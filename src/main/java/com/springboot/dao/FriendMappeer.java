package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FriendMappeer {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int addFriend(@RequestParam Map<String,Object> param) {
        String sql = "insert into friend (user_id,friend_id,time,status,status_time) values (?,?,?,?,?)";//SQL查询语句
        int result = jdbcTemplate.update(sql,param.get("user_id"),param.get("friend_id"),param.get("time"),param.get("status"),param.get("status_time"));
        return result;
    }
    public Map<String,Object> getIsFriend(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from friend where user_id = ? and friend_id = ?";//SQL查询语句
            Map<String, Object> mapObj = jdbcTemplate.queryForMap(sql,param.get("user_id"), param.get("friend_id"));
            return mapObj;
        }
        catch (Exception e){
            return null;
        }
    }
    public int editFriend(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE friend SET status = ? ,status_time = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{param.get("status"),param.get("status_time"),param.get("id")});
        return result;
    }
    public int removeFriend(@RequestParam Map<String,Object> param) {
        String sql = "delete from friend where id=?";//SQL删除语句
        int result = jdbcTemplate.update(sql, param.get("id"));
        return result;
    }
    public List<Map<String,Object>> getFriendList(@RequestParam Map<String,Object> param) {
        String sql = "select * from friend where user_id = ?";//SQL查询语句
        Object[] obj = new Object[]{param.get("user_id")};
        if(!(param.get("name") ==null||param.get("name")=="")) {
            sql = "select * from friend where user_id = ? and friend_id in(select id from user where user_name like '%' ? '%'  )";
            obj = new Object[]{param.get("user_id"),param.get("name")};
        }
        try {
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,obj);
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
    public List<Map<String,Object>> getIsStatusFriend(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select friend_id from friend where status and user_id = ?";//SQL查询语句
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,param.get("status"),param.get("user_id"));
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
}
