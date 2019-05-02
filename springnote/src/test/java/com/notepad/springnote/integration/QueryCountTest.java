package com.notepad.springnote.integration;

import com.notepad.springnote.config.InjectConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Description:
 * <p>
 * Create:      2018/8/25 0:29
 *
 * @author Yang Meng(eyangmeng@163.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class QueryCountTest {

    @Autowired
    private QueryCount queryCount;

    @Test
    public void testCount() throws Exception {
        String query = "spring integration test";
        List<String> chunks = queryCount.count(query);
        System.out.println("the result of integration: ");
        for (String item : chunks) {
            System.out.println(item);
        }
    }
}