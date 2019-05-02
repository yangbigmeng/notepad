package com.notepad.springnote.nosql.mongo.repository;

import com.notepad.springnote.config.InjectConfig;
import com.notepad.springnote.nosql.mongo.domain.Entity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Description: Entity实例化测试
 * <p>
 * Create:      2018/12/2 14:48
 *
 * @author Marvin Yang
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectConfig.class)
public class EntityRepositoryTest {

    @Autowired
    private EntityRepository entityRepository;

    @Test
    public void init() throws Exception {
        Assert.notNull(entityRepository);
    }

    @Test
    public void save() throws Exception {
        String name = "thing";
        Entity entity = new Entity();
        entity.setName(name);
        if (entityRepository.findByName(name) == null) {
            entityRepository.save(entity);
        }
        System.out.println("insert a entity name of: " + name);
    }

    @Test
    public void count() throws Exception {
        Long count = entityRepository.count();
        System.out.println("entity count is : " + count);
    }

    @Test
    public void find() throws Exception {
        List<Entity> entities = entityRepository.findAll();
        for (Entity e : entities) {
            System.out.println(e.getName());
        }
    }
}