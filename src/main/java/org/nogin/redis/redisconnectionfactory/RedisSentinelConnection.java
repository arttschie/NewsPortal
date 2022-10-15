package org.nogin.redis.redisconnectionfactory;

import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;

import java.util.concurrent.CompletableFuture;

public class RedisSentinelConnection implements RedisConnection {
    private RedisCommands redisCommands;

    @Override
    public RedisClusterCommands sync() {
        return this.redisCommands;
    }

    @Override
    public CompletableFuture<Void> closeAsync() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
