package com.notepad.thinkingnote.httpnote;

import java.util.Map;

/**
 * Description: http server client 接口
 * <p>
 * Create:      2018/6/30 22:55
 *
 * @author Yang Meng(eyangmeng@163.com)
 */
public interface HttpServerClient {

    /**
     * http server get请求处理
     *
     * @param url url
     * @return String, 查询结果
     * @throws Exception 获取结果失败
     */
    String get(String url) throws Exception;

    /**
     * http server post请求处理
     *
     * @param url url
     * @param params 参数列表
     * @return String, 查询结果
     * @throws Exception 获取结果失败
     */
    String post(String url, Map<String, String> params) throws Exception;
}
