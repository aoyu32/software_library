package com.aoyu.software_library.controller;

import com.aoyu.software_library.pojo.Result;
import com.aoyu.software_library.pojo.User;
import com.aoyu.software_library.service.UserService;
import com.aoyu.software_library.utils.HashUtil;
import com.aoyu.software_library.utils.JwtTokenUtil;
import com.aoyu.software_library.utils.ThreadLocalUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    //获取用户信息
    @Operation(summary = "用户信息")
    @GetMapping("/userinfo")
    public Result<User> userInfo(){
        //根据用户名查询用户
        //1.获取token中携带的username信息
//        Map<String, Object> map = JwtTokenUtil.decodeToken(token);
//        String username = (String) map.get("username");

        //1.使用ThreadLocal里存储的值
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        //2.使用username查询用户
        User user = userService.findByUsername(username);

        //响应数据
        return Result.success(user);

    }

    //更新用户信息
    @Operation(summary = "更新信息")
    @PutMapping("/update")
    public Result updateUserInfo(@RequestBody @Validated User user){
        //调用service层方法
        userService.update(user);
        return Result.success();
    }

    //更换头像
    @Operation(summary = "更新头像")
    @PatchMapping("/avatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    //更新密码
    @Operation(summary = "更新密码")
    @PatchMapping("/updatepwd")
    public Result updatePwd(@RequestBody Map<String,String> params) {
        //校验参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");

        //判断三个密码是否都不为空
        if (!StringUtils.hasLength(oldPwd) || !StringUtils.hasLength(newPwd) || !StringUtils.hasLength(rePwd)) {
            return Result.error("缺少必要参数!");
        }

        //原密码是否正确
        //查询原密码
        //从ThreadLocal里获取用户名
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        //根据用户名查询用户
        User user = userService.findByUsername(username);
        boolean isRight = HashUtil.verifyPassword(oldPwd, user.getPassword());
        if (!isRight){
            return Result.error("原密码错误!");
        }

        //判断新密码和rePwd是否一样
        if (!newPwd.equals(rePwd)){
            return Result.error("两次填写的密码不一致!");
        }

        //调用service完成密码更新
        userService.updatePwd(newPwd);
        return Result.success("密码已更新!");


    }

}
