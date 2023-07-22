package com.notepad.cache;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Description: 缓存接口实现
 * date: 2022/8/7
 *
 * @author Marvin Yang
 */
@Component
public class CacheServiceImpl implements CacheService {
    private static final JedisPool pool;

    private static final Logger LOGGER = LoggerFactory.getLogger(CacheService.class);

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(20);
        config.setMinIdle(5);
        pool = new JedisPool(config, "127.0.0.1", 6379, 3000);
    }

    @Override
    public void set(String key, String value) {
        try (Jedis jedis = pool.getResource()) {
            jedis.setex(key, 120, value);
        } catch (Exception e) {
            LOGGER.warn("set cache failed, message: {}", ExceptionUtils.getStackTrace(e));
        }
    }

    @Override
    public String get(String key) {
        try (Jedis jedis = pool.getResource()) {
            return jedis.get(key);
        } catch (Exception e) {
            LOGGER.warn("get cache failed, message: {}", ExceptionUtils.getStackTrace(e));
            return null;
        }
    }
}
