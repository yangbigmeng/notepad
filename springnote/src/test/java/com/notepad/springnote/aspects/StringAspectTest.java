package com.notepad.springnote.aspects;

import com.notepad.springnote.config.InjectConfig;
import com.notepad.springnote.inject.StringProcess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Description: 字符串切面测试
 * <p>
 * Create:      2018/7/18 0:23
 *
 * @author Marvin Yang
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class StringAspectTest {

    @Autowired
    private StringAspect stringAspect;

    @Autowired
    private StringProcess stringProcess;

    @Test
    public void testAspectParams() throws Exception {
        String test = "20180718年世界杯法国获得冠军";
        // around切面after获取return值, 没有输出, 感觉是有了阻碍
        String newStr = stringProcess.stringB2Q(test);
    }

}