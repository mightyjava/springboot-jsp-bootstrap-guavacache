package com.mightyjava.config;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
@EnableCaching
public class GuavaCacheConfig {
	
	@Bean
	public CacheManager cacheManager() {
		GuavaCacheManager cacheManager = new GuavaCacheManager();
		List<String> caches = new ArrayList<String>();
		caches.add("userCache");
		caches.add("addressCache");
		cacheManager.setCacheNames(caches);
		cacheManager.setCacheBuilder(CacheBuilder.newBuilder().maximumSize(100).expireAfterAccess(5, TimeUnit.MINUTES));
		return cacheManager;
	}
}
