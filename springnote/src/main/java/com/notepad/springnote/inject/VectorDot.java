package com.notepad.springnote.inject;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Description: 2个向量之间的点乘
 * <p>
 * Create:      2018/6/30 10:44
 *
 * @author Marvin Yang
 */
@Component
@Primary
public class VectorDot implements BaseVectorOperation {

    /**
     * 2个向量点乘运算: 2个向量长度需一致
     *
     * @param v1 向量1
     * @param v2 向量2
     * @return 运算结果
     * @throws Exception 计算异常
     */
    @Override
    public Double process(Double[] v1, Double[] v2) throws Exception {
        if (v1.length != v2.length) throw new AssertionError();
        double res = 0.0;
        for (int i = 0; i < v1.length; i++) {
            res += v1[i] * v2[i];
        }
        return res;
    }
}
