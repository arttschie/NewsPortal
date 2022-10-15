package org.nogin.redis.redisconnectionpoolfactory;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.nogin.redis.redisconnectionfactory.RedisConnection;

import java.util.List;

public class RedisSentinelConnectionPool extends RedisConnectionPool{
    public RedisSentinelConnectionPool(RedisConnection redisConnection, GenericObjectPoolConfig poolConfig,
                                      List<RedisURI> redisURIList) {
        super(redisConnection, poolConfig, redisURIList);
    }

    @Override
    public GenericObjectPool<RedisConnection> createConnectionPool(GenericObjectPoolConfig poolConfig,
                                                                   List<RedisURI> redisURIList) {
        RedisClient sentinelClient = RedisClient.create(redisURIList.get(0));
        GenericObjectPool<RedisConnection> redisClusterConnectionPool = ConnectionPoolSupport
                .createGenericObjectPool(() ->  sentinelClient.connect(), poolConfig);

        return redisClusterConnectionPool;
    }
}
