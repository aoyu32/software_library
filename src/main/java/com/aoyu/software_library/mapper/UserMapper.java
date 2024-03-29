package com.aoyu.software_library.mapper;

import com.aoyu.software_library.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    //根据用户名查询用户
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);

    //添加用户
    @Insert("insert into user(username,password,create_time,update_time) value(#{username},#{password},now(),now())")
    void addUser(String username, String password);

    //更新用户信息
    @Update("update user set username=#{username}, nickname=#{nickname},email=#{email},update_time=#{updateTime} where id=#{id}")
    void update(User user);

    //更新用户头像
    @Update("update user set user_pic=#{avatarUrl},update_time=now() where id=#{id}")
    void updateAvatar(String avatarUrl, Integer id);

    //更新用户密码
    @Update("update user set password=#{newPwd},update_time=now() where id=#{id}")
    void updatePwd(String newPwd, Integer id);

    //删除用户
    @Delete("delete from user where id=#{id}")
    void delete(Integer id);
}
