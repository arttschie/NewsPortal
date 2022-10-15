package org.nogin.redis.redisconnectionfactory;

public class RedisConnectionFactory {
    public static RedisConnection getRedisConnection(String redisType) {
        if (redisType.equalsIgnoreCase("CLUSTER")) {
            return new RedisClusterConnection();
        }
        return new RedisSentinelConnection();
    }
}
