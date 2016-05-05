package com.wonders.xlab.apisecurity

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.web.client.RestTemplate

@EnableCaching
@SpringBootApplication
class ApiSecurityApplication {

    @Bean
    RestTemplate restTemplate() {
        new RestTemplate()
    }

    @Bean
    CacheManager cacheManager(RedisConnectionFactory factory) {
        def template = new StringRedisTemplate(factory)
        template.setValueSerializer(new GenericJackson2JsonRedisSerializer())
        new RedisCacheManager(template)
    }

    static void main(String[] args) {
        SpringApplication.run ApiSecurityApplication, args
    }
}
