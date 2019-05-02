package com.notepad.springnote.inject;

import com.notepad.springnote.config.InjectConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description: 向量运算自测
 * <p>
 * Create:      2018/6/30 10:53
 *
 * @author Marvin Yang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class BaseVectorOperationTest {

    @Autowired
    @Qualifier(value = "vectorSum")
    private BaseVectorOperation operation;

    @Test
    public void testProcess() throws Exception {
        Double[] v1 = {0.1, 0.2};
        Double[] v2 = {0.1, 0.3};
        assert v1.length == v2.length;
        System.out.println(operation.process(v1, v2));
    }

}