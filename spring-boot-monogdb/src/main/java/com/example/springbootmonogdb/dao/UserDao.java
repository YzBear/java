package com.example.springbootmonogdb.dao;

import com.example.springbootmonogdb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 接口继承自MongoRepository，泛型分别为实体对象和主键类型。通过继承MongoRepository，UserDao包含了一些增删改查的方法，
 * UserDao通过继承MongoRepository已经具有了JPA的特性，我们可以通过方法名来构建多查询条件的SQL。比如通过用户的年龄段来查询
 */
@Repository
public interface UserDao extends MongoRepository<User,String> {
    /**
     * 根据年龄段来查找
     *
     * @param from from
     * @param to   to
     * @return List<User>
     */
    List<User> findByAgeBetween(Integer from,Integer to);

    /**
     * 通过年龄段，用户名，描述（模糊查询）
     *
     * @param from        from
     * @param to          to
     * @param name        name
     * @param description description
     * @return List<User>
     */
    List<User> findByAgeBetweenAndNameAndDescriptionLike(Integer from,Integer to,String name,String description);

}
