package org.nogin.redis.redisconnectionfactory;

import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;

import java.util.concurrent.CompletableFuture;

public class RedisClusterConnection implements RedisConnection {
    private RedisAdvancedClusterCommands redisAdvancedClusterCommands;

    @Override
    public RedisClusterCommands sync() {
        return this.redisAdvancedClusterCommands;
    }

    @Override
    public CompletableFuture<Void> closeAsync() {
        return null;
    }

    @Override
    public void close() throws Exception {

    }
}
