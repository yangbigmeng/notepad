package com.notepad;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by YM on 2017/6/4.
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "com.notepad")
@EnableCreateCacheAnnotation
public class HttpServerApplication {
    public static void main(String [] args) {
        SpringApplication.run(HttpServerApplication.class, args);
    }

}
