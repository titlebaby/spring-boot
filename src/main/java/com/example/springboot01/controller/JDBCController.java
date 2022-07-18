package com.example.springboot01.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("/userList")
    public List<Map<String, Object>> userList(){
        String sql = "select * from students";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;

    }
    @GetMapping("/addList")
    public String AddUser(){
        String s = "insert into test.students(age,class_id,name,create_time) value(30,1,'莉莉',1236547899)";
        jdbcTemplate.update(s);
        return "add user ok";
    }
    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String s = "update students set name=?, age=? where id="+id;
        Object[] objects = new Object[2];
        objects[0] = "hody";
        objects[1] = 30;
        jdbcTemplate.update(s, objects);
        return "update user ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String s = "delete from test.students  where id="+id;
        jdbcTemplate.update(s);
        return "delete-user ok";
    }
}
