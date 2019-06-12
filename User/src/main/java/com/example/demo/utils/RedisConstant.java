package com.example.demo.utils;

/**
 * Created by anpushang on 2015/12/31.1
 */
public interface RedisConstant {
    /***
     * redis ip，多个的话，就用,号区分 127.0.0.1:6379
     */
    String REDIS_POOL = "redis.pool";

    String REDIS_PWD = "redis.pwd";

    String REDIS_POOL_MAX_IDLE = "redis.pool.maxIdle";

    String REDIS_POOL_MAX_TOTAL = "redis.pool.maxTotal";

    String REDIS_POOL_MAX_WAIT_MILLIS = "redis.pool.maxWaitMillis";

    String REDIS_POOL_TEST_ON_BORROW = "redis.pool.testOnBorrow";

    String REDIS_ENCODE = "utf-8";



}
