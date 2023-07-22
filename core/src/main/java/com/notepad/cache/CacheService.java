package com.notepad.cache;

/**
 * Description: 缓存
 * date: 2022/8/7
 *
 * @author Marvin Yang
 */
public interface CacheService {

    void set(String key, String value);

    String get(String key);
}
