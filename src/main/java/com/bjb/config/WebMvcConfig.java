package com.bjb.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: jzhang
 * @WX: 15250420158
 * @Date: 2020/2/18 11:16
 * @Description: MVC的配置类
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //配置图片的访问路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //访问路径：localhost:8888/oa/public/film/xxx.jpg
        registry.addResourceHandler("/public/**").addResourceLocations("file:/D:/images/");
    }
}
