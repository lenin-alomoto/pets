package com.app.micro_pet_management.management.infrastructure.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
	@Bean
	CacheManager cacheManager() {
		return new ConcurrentMapCacheManager("dogBreeds");
	}
}
