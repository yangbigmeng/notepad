package com.notepad.thinkingnote.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: Java Config配置
 * <p>
 * Create:      2018/7/1 1:38
 *
 * @author Marvin Yang
 */
@Configuration
@ComponentScan(basePackages = "com.notepad.thinkingnote")
public class ThinkingNoteConfig {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor() {
        return new ThreadPoolExecutor(5, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());
    }
}
