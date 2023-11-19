package com.aoyu.software_library.controller;

import com.aoyu.software_library.pojo.Result;
import com.aoyu.software_library.pojo.User;
import com.aoyu.software_library.service.UserService;
import com.aoyu.software_library.utils.HashUtil;
import com.aoyu.software_library.utils.JwtTokenUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.controller
 * @Author: AoYu
 * @CreateTime: 2023-11-15  12:20
 * @Description: 用户控制器
 * @Version: 1.0
 */
@Tag(name = "用户管理")
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    UserService userService;

    //用户注册接口
    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{3,16}$") String username,@Pattern(regexp = "^\\S{3,16}$") String password){
        //查询用户名是否被占用
        User user = userService.findByUsername(username);
        if (user == null){
            //用户名没有被占用
            //注册用户
            userService.register(username,password);
            return Result.success();
        }else {
            //用户名被占用
            return Result.error("用户名已存在!");
        }

    }

    //用户登录
    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{3,16}$") String username,@Pattern(regexp = "^\\S{3,16}$") String password) {
        //根据用户名查询用户
        User loginUser = userService.findByUsername(username);
        //判断用户是否存在
        if (loginUser == null) {
            return Result.error("用户不存在");
        }
        //判断密码是否正确
        if (HashUtil.verifyPassword(password, loginUser.getPassword())) {

            //登录成功

            //封装用户数据的集合
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",loginUser.getId());
            claims.put("username",loginUser.getUsername());

            //生成token
            String token = JwtTokenUtil.generateToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误!");
    }

    //用户信息

}
