package com.namdev.jobportal.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//dùng để cấu hình đường dẫn đến thư mục lưu trữ file upload, giúp Spring Boot có thể phục vụ các tệp tin từ thư mục đó thông qua URL.
@Configuration
public class StaticResourcesWebConfiguration
        implements WebMvcConfigurer {

    @Value("${hoidanit.upload-file.base-uri}")
    private String baseURI;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/storage/**")
                .addResourceLocations(baseURI);
    }
}
