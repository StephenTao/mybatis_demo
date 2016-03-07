package com.stephen.mybatis;

import com.stephen.mybatis.dao.UserDao;
import com.stephen.mybatis.dao.impl.UserDaoImpl;
import com.stephen.mybatis.model.User;

public class TestUtil {

    /**
     * @param args
     */
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();
        
        User user = new User();
        user.setName("Stephen Huang");
        user.setAge(18);
        userDao.add(user);
        System.out.println("add user:" + user);
        
        System.out.println("get user id:" + user.getId());
        System.out.println(userDao.get(user.getId()));
        
        user.setAge(28);
        userDao.update(user);
        System.out.println("update user age=28:" + user);
        
        Integer userId = user.getId();
        userDao.delete(userId);
        System.out.println("delete user id=" + userId);
        System.out.println("get deleted user: " + userDao.get(userId));

    }

}
