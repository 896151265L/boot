package com.example.boot.Interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created
 * author:  lqk
 * 2019/7/30 14:59
 */
//@SpringBootConfiguration
public class InterceptorConfig implements WebMvcConfigurer {



    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //过滤的请求
        List<String> list = new ArrayList<>();
        list.add("/session/login");
        list.add("login.html");
        registry.addInterceptor(new GlobalInterceptor()).addPathPatterns("/**").excludePathPatterns(list);
    }
}
