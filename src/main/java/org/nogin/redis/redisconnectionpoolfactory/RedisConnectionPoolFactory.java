package org.nogin.redis.redisconnectionpoolfactory;

import io.lettuce.core.RedisURI;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.nogin.redis.redisconnectionfactory.RedisClusterConnection;
import org.nogin.redis.redisconnectionfactory.RedisConnection;

import java.util.List;

public class RedisConnectionPoolFactory {
    private RedisConnection redisConnection;
    private GenericObjectPoolConfig poolConfig;
    private List<RedisURI> redisURIList;

    GenericObjectPool<RedisConnection> getRedisConnectionPool(String redisType) {
        if (redisType.equalsIgnoreCase("CLUSTER")) {
            RedisClusterConnectionPool redisClusterConnectionPool = new RedisClusterConnectionPool(redisConnection, poolConfig,redisURIList);
            GenericObjectPool<RedisConnection> pool = redisClusterConnectionPool.createConnectionPool(poolConfig, redisURIList);
            return pool;
        }
        RedisSentinelConnectionPool redisSentinelConnectionPool = new RedisSentinelConnectionPool(redisConnection,
                poolConfig, redisURIList);
        GenericObjectPool<RedisConnection> pool = redisSentinelConnectionPool.createConnectionPool(poolConfig, redisURIList);
        return pool;
    }
}
