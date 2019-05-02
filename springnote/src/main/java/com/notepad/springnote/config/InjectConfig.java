package com.notepad.springnote.config;

import com.mongodb.MongoClientURI;
import com.notepad.springnote.aspects.StringAspect;
import com.notepad.springnote.inject.EncodeUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Description: Spring依赖注入Config(Java8)
 * <p>
 * Create:       2018/6/24 10:58
 *
 * @author Marvin Yang
 */

@Configuration
@ComponentScan(basePackages = "com.notepad.springnote")
@ImportResource(locations = {"classpath:inject-bean.xml", "classpath:integration-config.xml"})
@EnableAspectJAutoProxy
@EnableMongoRepositories(basePackages = "com.notepad.springnote")
public class InjectConfig {

    @Bean(name = "encodeUtilsConfig")
    public EncodeUtils getEncodeUtils() {
        EncodeUtils utils = new EncodeUtils();
        utils.setSeparate(utilSeparte);
        return utils;
    }

    @Bean
    public StringAspect stringAspect() {
        return new StringAspect();
    }

    @Bean
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        return new SimpleMongoDbFactory(new MongoClientURI(mongoDbUri));
    }

    /**
     * 定义mongo template
     *
     * @param mongoDbFactory a MongoDbFactory
     * @return a MongoOperations
     */
    @Bean
    public MongoTemplate mongoTemplate(MongoDbFactory mongoDbFactory) {
        // 去掉_class字段
        MappingMongoConverter converter = new MappingMongoConverter(new DefaultDbRefResolver(mongoDbFactory),
                new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(mongoDbFactory, converter);
        //return new MongoTemplate(mongoDbFactory);
    }

    @Value("${inject.separate.default}")
    private String utilSeparte;

    @Value("${spring.data.mongodb.uri}")
    private String mongoDbUri;

}
