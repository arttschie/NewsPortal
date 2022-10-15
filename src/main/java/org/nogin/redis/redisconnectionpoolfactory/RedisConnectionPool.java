package org.nogin.redis.redisconnectionpoolfactory;

import io.lettuce.core.RedisURI;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.nogin.redis.redisconnectionfactory.RedisConnection;
import org.nogin.redis.redisconnectionfactory.RedisConnectionFactory;

import java.util.List;

public abstract class RedisConnectionPool {
    private RedisConnection redisConnection;
    private GenericObjectPoolConfig poolConfig;
    private List<RedisURI> redisURIList;

    public RedisConnectionPool(GenericObjectPoolConfig poolConfig,
                               List<RedisURI> redisURIList, String redisType) {
        this.redisConnection = RedisConnectionFactory.getRedisConnection(redisType);
        this.poolConfig = poolConfig;
        this.redisURIList = redisURIList;
    }

    public abstract GenericObjectPool<RedisConnection> createConnectionPool(GenericObjectPoolConfig poolConfig,
                                                                            List<RedisURI> redisURIList);
}
