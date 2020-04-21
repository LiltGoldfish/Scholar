package com.quan.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisUtil {
    static JedisPool jedisPool;

    private JedisUtil() {
    }

    public static JedisPool getJedisPool() {
        if (null == jedisPool) {
            synchronized (JedisUtil.class) {
                if (jedisPool == null) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    //控制一个pool可分配多少个jedis实例
                    jedisPoolConfig.setMaxTotal(100);
                    //控制一个pool最多有多少个状态为idle(空闲)的jedis实例
                    jedisPoolConfig.setMaxIdle(32);
                    //表示当borrow一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛JedisConnectionException；
                    jedisPoolConfig.setMaxWaitMillis(100 * 1000);
                    //获得一个jedis实例的时候是否检查连接可用性（ping()）
                    jedisPoolConfig.setTestOnBorrow(true);
                    //jedisPool =  new JedisPool("127.0.0.1", 6379);
                    //指定连接的db 默认是db0
                    jedisPool = new JedisPool(jedisPoolConfig, "120.26.184.42", 6379);
                }
            }
        }
        return jedisPool;
    }
}
