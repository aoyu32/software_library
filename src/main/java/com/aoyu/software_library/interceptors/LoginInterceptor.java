package com.aoyu.software_library.interceptors;

import com.aoyu.software_library.utils.JwtTokenUtil;
import com.aoyu.software_library.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.interceptors
 * @Author: AoYu
 * @CreateTime: 2023-11-19  15:31
 * @Description: 登录拦截器,所有请求都需要进行登录认证
 * @Version: 1.0
 */

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //令牌验证
        String token = request.getHeader("Authorization");

        try {
            //验证token
            Map<String, Object> claims = JwtTokenUtil.decodeToken(token);

            //把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);

            //放行
            return true;
        }catch (Exception e){
            //设置响应状态码
            response.setStatus(401);
            //不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //清空ThreadLocal里的数据
        ThreadLocalUtil.clear();
    }
}
