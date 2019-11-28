package com.bms.config;

import com.bms.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SiteWebMvcConfigurer implements WebMvcConfigurer {

    @Autowired
    private UploadConfig uploadConfig;
    @Autowired
    private LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        String[] exclidePaths = {"/admin/login", "/admin/dist/**", "/admin/plugins/**", "/common/kaptcha", "/errorPage/**", "/index/css/**", "/index/img/**", "/index/js/**", "/index/plugins/**"};
        // 添加一个拦截器，拦截所有的url路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns(exclidePaths);
    }

    // 配置请求映射 请求中 /files/** 会映射到 uploadConfig.getPath()位置
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/files/**").addResourceLocations("file:" + uploadConfig.getPath());
    }

}
