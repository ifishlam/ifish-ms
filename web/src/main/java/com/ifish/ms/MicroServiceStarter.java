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

package com.ifish.ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ifish.ms.core.*")
@EnableJpaRepositories(basePackages = "com.ifish.ms.core.dao")
@EntityScan(basePackages = "com.ifish.ms.core.bean")
@EnableCaching
public class MicroServiceStarter {

    public static void main(String[] args) {

        SpringApplication.run(MicroServiceStarter.class, args);
    }
}
