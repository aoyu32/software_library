package com.aoyu.software_library.service;

import com.aoyu.software_library.pojo.User;

public interface UserService {
    //query user
    User findByUsername(String username);

    //register user
    void register(String username,String password);

    //update user information
    void update(User user);
}
