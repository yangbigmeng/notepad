package com.notepad.cache;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import org.springframework.stereotype.Component;

/**
 * Description: User操作
 * date: 2022/7/23
 *
 * @author Marvin Yang
 */
@Component
public class UserService {
    @CreateCache(expire = 100, cacheType = CacheType.REMOTE, localLimit = 100)
    private Cache<String, String> userCache;

    public boolean save(String userId) {
        userCache.put(userId, userId);
        return true;
    }

    public String find(String userId) {
        return userCache.get(userId);
    }
}
