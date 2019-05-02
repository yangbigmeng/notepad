package com.notepad.springnote.inject;

import com.notepad.springnote.config.InjectConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:  字符串处理测试
 * <p>
 * Create:       2018/6/24 11:08
 *
 * @author Marvin Yang
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class StringProcessTest {

    @Autowired
    private StringProcess stringProcess;

    @Test
    public void stringQ2B() {
        String con = "２０１８世界杯德国２:０胜出。";
        String rCon = stringProcess.stringQ2B(con);
        System.out.println(rCon);
        Assert.assertEquals("2018世界杯德国2:0胜出。", rCon);
    }

    @Test
    public void stringB2Q() {
        String con = "2018世界杯德国2:0胜出。";
        String rCon = stringProcess.stringB2Q(con);
        System.out.println(rCon);
        Assert.assertEquals("２０１８世界杯德国２：０胜出。", rCon);
    }
}