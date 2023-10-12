package com.springboot.config;


import com.springboot.mayinterceptor.MayInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    MayInterceptor mayInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mayInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/user/addUser")
                .excludePathPatterns("/api/user/editUserPassword")
                .excludePathPatterns("/api/publish/listPublishAll")
                .excludePathPatterns("/api/user/login");
    }
}
