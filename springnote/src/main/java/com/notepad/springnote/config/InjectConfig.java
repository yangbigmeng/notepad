package com.notepad.springnote.config;

import com.notepad.springnote.inject.EncodeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Description: Spring依赖注入Config(Java8)
 * <p>
 * Create:       2018/6/24 10:58
 *
 * @author Yang Meng(eyangmeng@163.com)
 */

@Configuration
@ComponentScan(basePackages = "com.notepad.springnote")
@ImportResource("classpath:inject-bean.xml")
public class InjectConfig {

    @Bean(name = "encodeUtilsConfig")
    public EncodeUtils getEncodeUtils() {
        EncodeUtils utils = new EncodeUtils();
        utils.setSeparate(utilSeparte);
        return utils;
    }

    @Value("${inject.separate.default}")
    private String utilSeparte;
}
