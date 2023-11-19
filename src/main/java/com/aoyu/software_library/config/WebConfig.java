package com.aoyu.software_library.config;

import com.aoyu.software_library.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @BelongsProject: software_library
 * @BelongsPackage: com.aoyu.software_library.config
 * @Author: AoYu
 * @CreateTime: 2023-11-19  15:37
 * @Description: TODO
 * @Version: 1.0
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登录和注册接口和swagger接口不拦截
        // 对swagger的请求不进行拦截
        String[] excludePatterns = new String[]{"/user/login","/user/register"," /swagger-resources/**", "/webjars/**", "/v3/**", "/swagger-ui.html/**",
                "/api", "/api-docs", "/api-docs/**", "/doc.html/**"};

        registry.addInterceptor(loginInterceptor).excludePathPatterns(excludePatterns);
    }
}
