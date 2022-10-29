package com.benggrea.springredisstrategy.config

import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig(val redisProperties: RedisProperties) {

    @Bean
    fun lettuceConnectionFactory(): RedisConnectionFactory {
        return LettuceConnectionFactory(redisProperties.host, redisProperties.port)
    }

    @Bean
    fun redisTemplate(): RedisTemplate<Any, Any> {
        val redisTemplate = RedisTemplate<Any, Any>()
        redisTemplate.setConnectionFactory(lettuceConnectionFactory())
        return redisTemplate
    }
}
