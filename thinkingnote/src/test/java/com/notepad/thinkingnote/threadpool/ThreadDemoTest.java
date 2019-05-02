package com.notepad.thinkingnote.threadpool;

import com.notepad.thinkingnote.config.ThinkingNoteConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.concurrent.ThreadPoolExecutor;

import static org.junit.Assert.*;

/**
 * Description:
 * <p>
 * Create:      2018/9/30 21:29
 *
 * @author Marvin Yang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ThinkingNoteConfig.class)
public class ThreadDemoTest {

    @Autowired
    private ThreadPoolExecutor executor;

    @Test
    public void run() throws Exception {
        for (int i = 1; i < 50; i++ ) {
            executor.execute(new ThreadDemo());
        }
        executor.shutdown();
    }
}