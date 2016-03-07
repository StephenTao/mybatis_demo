package com.stephen.mybatis.dao;

import com.stephen.mybatis.model.User;

public interface UserDao {

    Boolean add(User user);

    Boolean delete(Integer id);

    Boolean update(User user);

    User get(Integer id);
}
