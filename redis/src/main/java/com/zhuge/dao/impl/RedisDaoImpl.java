package com.zhuge.dao.impl;

import com.zhuge.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDaoImpl implements RedisDao {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public void setKey(String key, String value) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set(key, value);
    }

    @Override
    public String getValue(String key) {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        return ops.get(key);
    }
}
