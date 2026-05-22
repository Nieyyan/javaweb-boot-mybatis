package com.woxueit.boot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    //读取配置文件：upload.path的值
    @Value("${upload.path}")
    private String uploadPath;

    /**
     * 项目启动时自动创建上传文件夹
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 自动创建目录
        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }

        // 映射上传文件路径，可以通过 http://localhost:8080/files/文件名 访问
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:" + uploadPath);
    }

    /**
     * 跨域配置（前端调用必开）
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowCredentials(true)
                .maxAge(3600);
    }
}