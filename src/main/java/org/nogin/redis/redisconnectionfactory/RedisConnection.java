package org.nogin.redis.redisconnectionfactory;

import io.lettuce.core.api.AsyncCloseable;
import io.lettuce.core.cluster.api.sync.RedisClusterCommands;

public interface RedisConnection extends AutoCloseable, AsyncCloseable {
    RedisClusterCommands sync();
}
