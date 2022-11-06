package com.benggrea.springredisstrategy.config

import com.benggrea.springredisstrategy.domain.Data
import com.benggrea.springredisstrategy.infra.DataJpaRepository
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.StringKeySerializer
import com.fasterxml.jackson.databind.ser.std.StringSerializer
import org.springframework.boot.autoconfigure.data.redis.RedisProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import javax.annotation.PostConstruct

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
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.valueSerializer = GenericJackson2JsonRedisSerializer()
        return redisTemplate
    }
}


@Configuration
class SampleDataWarmUp(
    val dataJpaRepository: DataJpaRepository,
    val redisTemplate: RedisTemplate<Any, Any>
    ) {

    @PostConstruct
    fun setUp() {
        val datas = listOf(Data("a"), Data("b"), Data("c"))
        dataJpaRepository.saveAll(datas)
        redisTemplate.opsForSet().add("data", datas)
    }

}
