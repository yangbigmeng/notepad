package com.notepad.thinkingnote.httpnote;

import com.notepad.thinkingnote.config.ThinkingNoteConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: http server 自测
 * <p>
 * Create:      2018/7/1 1:28
 *
 * @author Yang Meng(eyangmeng@163.com)
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ThinkingNoteConfig.class)
public class HttpServerClientImplTest {

    @Autowired
    private HttpServerClient client;

    @Test
    public void testGet() throws Exception {
        String url = "https://blog.csdn.net/ymaini/article/details/80796134";
        String result = client.get(url);
        System.out.println(result);
    }

    @Test
    public void testPost() throws Exception {
        String url = "https://blog.csdn.net/ymaini/article/details/80796134";
        Map<String, String> params = new HashMap<>(4);
        params.put("name", "csdn");
        params.put("age", "4");
        System.out.println(client.post(url, params));
    }
}