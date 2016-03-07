package com.stephen.mybatis.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;

import com.stephen.mybatis.dao.UserDao;
import com.stephen.mybatis.model.User;

public class UserDaoImplSpring implements UserDao {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_ADD = ".add";
    private static final String SQL_ID_DELETE = ".delete";
    private static final String SQL_ID_GET = ".get";
    private static final String SQL_ID_UPDATE = ".update";

    private SqlSessionTemplate sqlSessionTemplate;
    
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
    
    public SqlSessionTemplate getSqlSessionTemplate() {
        return sqlSessionTemplate;
    }

    @Override
    public Boolean add(User user) {
        this.sqlSessionTemplate.insert(CLASS_NAME + SQL_ID_ADD, user);
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Integer id) {
        this.sqlSessionTemplate.delete(CLASS_NAME + SQL_ID_DELETE, id);
        return Boolean.TRUE;
    }

    @Override
    public Boolean update(User user) {
        this.sqlSessionTemplate.update(CLASS_NAME + SQL_ID_UPDATE, user);
        return Boolean.TRUE;
    }

    @Override
    public User get(Integer id) {
        return this.sqlSessionTemplate.selectOne(CLASS_NAME + SQL_ID_GET, id);
    }

}
