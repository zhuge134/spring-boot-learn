package com.zhuge.dao;

public interface RedisDao {

    void setKey(String key, String value);

    String getValue(String key);

    void publish(String channel, String msg);
}
