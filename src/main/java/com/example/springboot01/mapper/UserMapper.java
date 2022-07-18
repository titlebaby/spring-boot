package com.example.springboot01.mapper;


import com.example.springboot01.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

// 这个注解表示这是一个mybatis的mapper类： 扫描 如mapperScan("包名")
@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    User queryUserById(int id);
    int updateUser(User user);
    int addUser(User user);
    int deleteUser(int id);
}
