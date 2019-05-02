package com.notepad.springnote.nosql.mongo.repository;

import com.notepad.springnote.nosql.mongo.domain.Entity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:
 * <p>
 * Create:      2018/12/2 14:46
 *
 * @author Marvin Yang
 */
@Repository
public interface EntityRepository extends MongoRepository<Entity, String> {

    /**
     * 根据name搜索entity
     *
     * @param name 实体名称
     * @return 记录
     */
    Entity findByName(String name);
}