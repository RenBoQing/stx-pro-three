package com.stx.pro.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author RenBoQing
 * @date 2022年03月24日 19:39
 * @Description 配置文件 拦截器
 */
@Configuration
public class MyWebConfig implements WebMvcConfigurer {
    @Autowired
    @Qualifier(value = "loginInterceptor")
    private HandlerInterceptor handlerInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加拦截器
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(handlerInterceptor);
        //拦截的请求
        interceptorRegistration.addPathPatterns("");
        //放行请求
        interceptorRegistration.excludePathPatterns(
                "/login",
                "/sysuser/login",
                "/sysuser/logout",
                "/layui/**",
                "/api/**",
                "/css/**",
                "/images/**",
                "/js/**",
                "/lib/**",
                "/captcha",
                "/hosptial/**",
                "/address/**",
                "/user/**",
                "/getLonLat/**",
                "/admin/**",
                "/component/**",
                "/config/**",
                "/pear.config.json",
                "/adminLogin",
                "/sysUsers/**"
        );
    }
}
