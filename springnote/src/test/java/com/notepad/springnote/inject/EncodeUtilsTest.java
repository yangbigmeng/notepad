package com.notepad.springnote.inject;

import com.notepad.springnote.config.InjectConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Description: 汉字转拼音测试
 * <p>
 * Create:      2018/6/24 12:13
 *
 * @author Yang Meng(eyangmeng@163.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class EncodeUtilsTest {

    @Autowired
    private EncodeUtils encodeUtils;

    @Test
    public void string2PinYin() throws Exception {
        String con = "2018世界杯";
        System.out.println(encodeUtils.string2Pinyin(con));
    }
}