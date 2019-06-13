package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor loginInterceptor(){
        return  new LoginInterceptor();
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/");

//        registry
//                .addResourceHandler("/lib/**")
//                .addResourceLocations("classpath:/lib/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册自定义拦截器，添加拦截路径和排除拦截路径
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/lib/**","/view/login.html");
//                .excludePathPatterns("/error","/login/*",
//                        "/webjars/**","/swagger-resources/**","/v2/api-docs","/configuration/**","/swagger-ui.html");//Swagger2 接口API文档资源放行
    }
}
