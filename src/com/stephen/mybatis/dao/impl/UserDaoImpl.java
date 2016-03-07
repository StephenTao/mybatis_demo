package com.stephen.mybatis.dao.impl;

import com.stephen.mybatis.util.MybatisUtil;
import com.stephen.mybatis.dao.UserDao;
import com.stephen.mybatis.model.User;

public class UserDaoImpl implements UserDao {

    private static final String CLASS_NAME = User.class.getName();
    private static final String SQL_ID_ADD = ".add";
    private static final String SQL_ID_DELETE = ".delete";
    private static final String SQL_ID_GET = ".get";
    private static final String SQL_ID_UPDATE = ".update";

    @Override
    public Boolean add(User user) {
        try {
            MybatisUtil.getSession().insert(CLASS_NAME + SQL_ID_ADD, user);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.getSession().rollback();
            return Boolean.FALSE;
        } finally {
            MybatisUtil.closeSession();
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Integer id) {
        try {
            MybatisUtil.getSession().delete(CLASS_NAME + SQL_ID_DELETE,id);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.getSession().rollback();
            return Boolean.FALSE;
        } finally {
            MybatisUtil.closeSession();
        }
        return Boolean.TRUE;
    }

    @Override
    public Boolean update(User user) {
        try {
            MybatisUtil.getSession().update(CLASS_NAME + SQL_ID_UPDATE, user);
            MybatisUtil.getSession().commit();
        } catch (Exception e) {
            e.printStackTrace();
            MybatisUtil.getSession().rollback();
            return Boolean.FALSE;
        } finally {
            MybatisUtil.closeSession();
        }
        return Boolean.TRUE;
    }

    @Override
    public User get(Integer id) {
        User user = null;
        try {
            user = MybatisUtil.getSession().selectOne(CLASS_NAME + SQL_ID_GET, id);
        } finally {
            MybatisUtil.closeSession();
        }
        return user;
    }

}
