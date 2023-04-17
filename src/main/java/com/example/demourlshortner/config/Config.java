package com.example.demourlshortner.config;

import com.example.demourlshortner.model.ShortUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class Config {
    @Bean
    public RedisTemplate<String, ShortUrl> redisTemplate() {
        var redisTemplate = new RedisTemplate<String, ShortUrl>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
}