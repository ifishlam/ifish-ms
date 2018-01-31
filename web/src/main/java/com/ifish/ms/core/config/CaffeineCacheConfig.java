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

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableCaching
public class CaffeineCacheConfig {

    public static final int DEFAULT_CACHE_VALID_TIME_IN_SECOND = 86400;
    public static final int DEFAULT_CACHE_MAX_SIZE = 50000;
    public static final int DEFAULT_CACHE_TIME_TO_LIVE = 86400;

    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        ArrayList<CaffeineCache> caches = new ArrayList<CaffeineCache>();
        for (Caches cache : Caches.values()) {

            caches.add(new CaffeineCache(cache.name(),
                Caffeine.newBuilder().recordStats()
                    .expireAfterWrite(cache.getTtl(), TimeUnit.SECONDS)
                    .maximumSize(cache.getMaxSize())
                    .build())
            );
        }
        cacheManager.setCaches(caches);

        return cacheManager;
    }

    public enum Caches {

        // List all the cache methods here
        securityUserService(DEFAULT_CACHE_VALID_TIME_IN_SECOND),
        systemService(DEFAULT_CACHE_VALID_TIME_IN_SECOND),
        securityAdminService(DEFAULT_CACHE_VALID_TIME_IN_SECOND);


        private int maxSize = DEFAULT_CACHE_MAX_SIZE;
        private int ttl = DEFAULT_CACHE_TIME_TO_LIVE;

        Caches() {
        }

        Caches(int ttl) {
            this.ttl = ttl;
        }

        Caches(int ttl, int maxSize) {
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public int getMaxSize() {
            return maxSize;
        }

        public int getTtl() {
            return ttl;
        }
    }
}
