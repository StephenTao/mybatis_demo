package com.stephen.mybatis.dao;

import org.apache.ibatis.annotations.*;

import com.stephen.mybatis.model.User;

public interface UserDaoAnnotation {

    //使用@Insert注解指明add方法要执行的SQL
    @Insert("INSERT INTO users(name, age) VALUES(#{name}, #{age})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    Boolean add(User user);

    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("DELETE FROM users WHERE id=#{id}")
    Boolean delete(Integer id);

    //使用@Update注解指明update方法要执行的SQL
    @Update("UPDATE users SET name=#{name},age=#{age} WHERE id=#{id}")
    Boolean update(User user);

    //使用@Select注解指明getById方法要执行的SQL
    @Select("SELECT * FROM users WHERE id=#{id}")
    @Results({
        @Result(id = true, column = "id", property = "id"),
        @Result(column = "name", property = "name"),
        @Result(column = "age", property = "age")
    })
    User get(Integer id);
}
