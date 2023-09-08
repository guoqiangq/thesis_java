package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserMappeer {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> getUsers(@RequestParam Map<String,Object> param) {
        String sql = "select * from user";//SQL查询语句
//        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
//        return list;
//        String sql = "select * from publish where user_id = ?";
        Object[] obj = new Object[]{};
        if(!(param.get("name") ==null||param.get("name")=="")) {
            sql = "select * from user where user_name like '%' ? '%' ";
            obj = new Object[]{param.get("name")};
        }
        try {
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,obj);
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
    public Map<String,Object> addUser(@RequestParam Map<String,Object> param) {
        String sql = "insert into user (user_name,password,login_name,email,phone,gender,time,status) values (?,?,?,?,?,?,?,?)";//SQL查询语句
        jdbcTemplate.update(sql,param.get("user_name"),param.get("password"),param.get("login_name"),param.get("email"),param.get("phone"),param.get("gender"),param.get("time"),param.get("status"));
        Map<String,Object> obj = new HashMap<String,Object>();
        obj.put("code","0");
        obj.put("data","成功!");
        return obj;
    }
    public Map<String,Object> getUser(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from user where login_name = ? and password = ? ";//SQL查询语句
            Map<String, Object> mapObj = jdbcTemplate.queryForMap(sql, param.get("login_name"),param.get("password"));
            return mapObj;
        }
        catch (Exception e){
            return null;
        }

    }
    public Map<String,Object> getUserId(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from user where id = ? ";//SQL查询语句
            Map<String, Object> mapObj = jdbcTemplate.queryForMap(sql, param.get("id"));
            return mapObj;
        }
        catch (Exception e){
            return null;
        }
    }
    public int editUser(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE user SET user_name = ?,gender = ? , avatar = ?,email = ? ,phone = ? , remark = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{param.get("user_name"), param.get("gender"), param.get("avatar"), param.get("email"), param.get("phone"), param.get("remark"), param.get("id")});
        return result;
    }
    public int editStatusUser(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE user SET status = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{ param.get("status"), param.get("id")});
        return result;
    }
    public int editUserPassword(@RequestParam Map<String,Object> param) {
        String sql = "UPDATE user SET user_name = ? WHERE id = ?";//SQL修改语句
        int result = jdbcTemplate.update(sql, new Object[]{param.get("password"),param.get("id")});
        return result;
    }
}
