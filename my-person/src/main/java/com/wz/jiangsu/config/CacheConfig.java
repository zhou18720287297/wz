package com.wz.jiangsu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 */
@Configuration
public class CacheConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        //默认的Key序列化器为：JdkSerializationRedisSerializer
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));
        redisTemplate.setConnectionFactory(connectionFactory);
        //初始化设置
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

    /**
     * 构建缓存bean
     * @return
     */
//    @Bean
//    public Cache<String,Object> caffeineCache(){
//        Cache<String, Object> cache = Caffeine
//                .newBuilder()
//                .maximumSize(200)//设置缓存数量上限
////                .expireAfterAccess(1, TimeUnit.SECONDS)//访问1秒后删除
////                .expireAfterWrite(1,TimeUnit.SECONDS)//写入1秒后删除
//                .initialCapacity(20)// 初始的缓存空间大小
//                .recordStats()//开启统计
//                .build();
//        return cache;
//    }



}