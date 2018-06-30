package com.notepad.springnote.inject;

/**
 * Description: 2个向量之间的运算接口
 * <p>
 * Create:      2018/6/30 10:41
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public interface BaseVectorOperation {

    /**
     * 2个向量运算
     *
     * @param v1 向量1
     * @param v2 向量2
     * @return 运算结果
     * @throws Exception 计算异常
     */
    Double process(Double[] v1, Double[] v2) throws Exception;
}
