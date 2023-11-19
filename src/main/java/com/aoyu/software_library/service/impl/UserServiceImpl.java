package com.aoyu.software_library.service.impl;

import com.aoyu.software_library.mapper.UserMapper;
import com.aoyu.software_library.pojo.User;
import com.aoyu.software_library.service.UserService;
import com.aoyu.software_library.utils.HashUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void register(String username,String password) {
        //password encryption
        String hashPassword = HashUtil.hashPassword(password);
        //add user
        userMapper.addUser(username,hashPassword);
    }
}
