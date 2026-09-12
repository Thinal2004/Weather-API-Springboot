package com.example.weatherapi;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Applies this rule to all your API endpoints
                .allowedOrigins("https://weather-dashboard-frontend-plum.vercel.app/") // Allows frontend to connect (useful for dev)
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
