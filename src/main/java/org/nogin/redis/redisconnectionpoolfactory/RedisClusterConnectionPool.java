package org.nogin.redis.redisconnectionpoolfactory;

import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.support.ConnectionPoolSupport;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.nogin.redis.redisconnectionfactory.RedisConnection;
import org.nogin.redis.redisconnectionfactory.RedisConnectionFactory;

import java.util.List;

public class RedisClusterConnectionPool extends RedisConnectionPool {
    public static final String REDIS_TYPE = "cluster";
    RedisConnection redisConnection = RedisConnectionFactory.getRedisConnection(REDIS_TYPE);

    public RedisClusterConnectionPool(GenericObjectPoolConfig poolConfig,
                                      List<RedisURI> redisURIList) {
        super(poolConfig, redisURIList, REDIS_TYPE);
    }

    @Override
    public GenericObjectPool<RedisConnection> createConnectionPool(GenericObjectPoolConfig poolConfig,
                                                                   List<RedisURI> redisURIList) {
        RedisClusterClient clusterClient = RedisClusterClient.create(redisURIList.get(0));
        GenericObjectPool<RedisConnection> redisClusterConnectionPool = ConnectionPoolSupport
                .createGenericObjectPool(() ->  clusterClient.connect(), poolConfig);

        return redisClusterConnectionPool;
    }
}
