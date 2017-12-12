package com.cfq.demo.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
/**
 * 
 * @描述: 静态注入中间类
 * @版权: Copyright (c) 2017 
 * @作者: cfq
 * @版本: 1.0 
 * @创建日期: 2017年12月08日 
 * @创建时间: 上午10:26:33
 */
public class RedisCacheTransfer {
	@Autowired
    public void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
        RedisCache.setJedisConnectionFactory(jedisConnectionFactory);
    }
}
