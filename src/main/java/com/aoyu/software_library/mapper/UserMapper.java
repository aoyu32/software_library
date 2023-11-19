package com.aoyu.software_library.mapper;

import com.aoyu.software_library.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    //添加用户
    @Insert("insert into user(username,password,create_time,update_time) value(#{username},#{password},now(),now())")
    void addUser(String username, String password);
}
