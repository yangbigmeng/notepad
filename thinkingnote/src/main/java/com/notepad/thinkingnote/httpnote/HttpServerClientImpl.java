package com.notepad.thinkingnote.httpnote;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Description: http server client接口实现
 * <p>
 *
 * </p>
 * Create:      2018/6/30 23:01
 *
 * @author Marvin Yang
 */

@Component
public class HttpServerClientImpl implements HttpServerClient {

    /**
     * http server get请求处理
     *
     * @param url url
     * @return String, 查询结果
     */
    @Override
    public String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setConfig(defaultRequestConfig);
        httpGet.setHeader(defaultHeader);
        try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (Exception e) {
            e.printStackTrace();
            LOG.error("http server get failed. {}", e.getMessage());
        }
        return null;
    }

    /**
     * http server post请求处理
     *
     * @param url    url
     * @param params 参数列表
     * @return String, 查询结果
     */
    @Override
    public String post(String url, Map<String, String> params) {
        HttpPost httpPost = new HttpPost(url + map2string(params));
        httpPost.setConfig(defaultRequestConfig);
        httpPost.setHeader(defaultHeader);
        try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
            HttpEntity httpEntity = response.getEntity();
            return EntityUtils.toString(httpEntity);
        } catch (Exception e) {
            LOG.error("http server get failed. {}", e.getMessage());
        }
        return null;
    }

    /**
     * 将参数值对构造为字符串
     *
     * @param params 参数值对
     * @return String, 构造的字符串
     */
    private String map2string(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> item : params.entrySet()) {
            stringBuilder.append(item.getKey()).append("=").append(item.getValue()).append("&");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    /**
     * 构造HttpClient和request配置
     *
     * @return true, 加载成功
     */
    @PostConstruct
    public boolean load() {
        try {
            httpClient = HttpClients.createDefault();
            defaultRequestConfig = RequestConfig.custom().
                    setConnectTimeout(CONNECT_TIME_OUT).
                    setSocketTimeout(SOCKET_TIME_OUT).
                    setConnectionRequestTimeout(CONNECT_REQUEST_TIME_OUT).build();
            defaultHeader = new BasicHeader(DEFAULT_FIELD, DEFAULT_VALUE);
            return true;
        } catch (Exception e) {
            LOG.error("get httpclient failed. {}", e.getMessage());
            return false;
        }
    }

    /** http client */
    private CloseableHttpClient httpClient;

    /** 默认配置 */
    private RequestConfig defaultRequestConfig;

    /** 默认请求头 */
    private BasicHeader defaultHeader;
    private final static String DEFAULT_FIELD = "connection";
    private final static String DEFAULT_VALUE = "close";

    /** 接口时间设置 */
    private final static int CONNECT_TIME_OUT = 30000;
    private final static int SOCKET_TIME_OUT = 30000;
    private final static int CONNECT_REQUEST_TIME_OUT = 30000;

    private final static Logger LOG = LoggerFactory.getLogger(HttpServerClientImpl.class);
}
