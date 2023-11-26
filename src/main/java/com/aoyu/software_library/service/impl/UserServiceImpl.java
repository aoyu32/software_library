package com.aoyu.software_library.service.impl;

import com.aoyu.software_library.mapper.UserMapper;
import com.aoyu.software_library.pojo.User;
import com.aoyu.software_library.service.UserService;
import com.aoyu.software_library.utils.HashUtil;
import com.aoyu.software_library.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.service.impl
 * @Author: AoYu
 * @CreateTime: 2023-11-15  12:27
 * @Description: 用户服务层接口实现类
 * @Version: 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户名查询用户
     * @param username 用户名
     * @return User对象
     */
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    /**
     * 用户注册
     * @param username 用户名
     * @param password 登录密码
     */
    @Override
    public void register(String username,String password) {
        //password encryption
        String hashPassword = HashUtil.hashPassword(password);
        //add user
        userMapper.addUser(username,hashPassword);
    }


    /**
     * 更新用户信息
     * @param user 携带更新信息的实体类
     */
    @Override
    public void update(User user) {
        //设置用户信息更新时间
        user.setUpdateTime(LocalDateTime.now());
        userMapper.update(user);
    }

    /**
     * 更新用户头像
     * @param avatarUrl 头像url
     */
    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updateAvatar(avatarUrl,id);
    }

    /**
     * 更新用户登录密码
     * @param newPwd 新密码
     */
    @Override
    public void updatePwd(String newPwd) {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer id = (Integer) map.get("id");
        userMapper.updatePwd(HashUtil.hashPassword(newPwd),id);
    }

    @Override
    public void delete(Integer id) {
        userMapper.delete(id);
    }
}
