package com.example.kotlinback.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan("com.example.kotlinback")
public class AppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("POST", "GET", "PUT", "DELETE")
                .allowedHeaders("Content-Type")
                .exposedHeaders("header-1", "header-2")
                .allowCredentials(false)
                .maxAge(6000);

    }
}