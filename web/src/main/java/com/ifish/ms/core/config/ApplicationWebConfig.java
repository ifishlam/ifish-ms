/*
 * Copyright (c) 2017. iFish Studio.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *
 * @author Angus Lam
 * @date 2017/10/20
 *
 *
 */

package com.ifish.ms.core.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class ApplicationWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ApplicationInterceptor())
            .addPathPatterns("/api/**")
            .excludePathPatterns("/api/public/**");
        super.addInterceptors(registry);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/api/**")
            .allowedOrigins("*")
            .allowedMethods("GET", "PUT", "DELETE", "OPTIONS")
            .allowedHeaders("x-requested-with")
            .allowCredentials(true)
            .maxAge(3600);
        super.addCorsMappings(registry);
    }
}
