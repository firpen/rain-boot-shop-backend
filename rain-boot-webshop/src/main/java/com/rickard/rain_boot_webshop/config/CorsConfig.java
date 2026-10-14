package com.rickard.rain_boot_webshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/* https://www.baeldung.com/spring-cors */
@Configuration 
public class CorsConfig implements WebMvcConfigurer {
    
    @Value("${frontend.url}")
    private String frontendUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins(frontendUrl)
        .allowedMethods("POST", "GET", "DELETE");
    }

}
