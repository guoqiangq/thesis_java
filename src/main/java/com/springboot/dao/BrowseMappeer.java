package com.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BrowseMappeer {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int addBrowse(@RequestParam Map<String,Object> param) {
        String sql = "insert into browse (user_id,essay_id,time) values (?,?,?)";//SQL查询语句
        int result = jdbcTemplate.update(sql,param.get("user_id"),param.get("essay_id"),param.get("time"));
        return result;
    }
    public int removeBrowse(@RequestParam Map<String,Object> param) {
        String sql = "delete from browse where id=?";//SQL删除语句
        int result = jdbcTemplate.update(sql, param.get("id"));
        return result;
    }
    public List<Map<String,Object>> getBrowseList(@RequestParam Map<String,Object> param) {
        try {
            String sql = "select * from browse where user_id = ?";//SQL查询语句
            List<Map<String, Object>> list = jdbcTemplate.queryForList(sql,param.get("user_id"));
            return list;
        }
        catch (Exception e){
            return new ArrayList<>();
        }
    }
}
