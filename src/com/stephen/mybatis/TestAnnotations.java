package com.stephen.mybatis;

import com.stephen.mybatis.dao.UserDaoAnnotation;
import com.stephen.mybatis.model.User;
import com.stephen.mybatis.util.MybatisUtil;

public class TestAnnotations {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //得到UserDaoAnnotation接口的实现类对象，UserDaoAnnotation接口的实现类对象由
        //sqlSession.getMapper(UserDaoAnnotation.class)动态构建出来
        UserDaoAnnotation userDao =
                MybatisUtil.getSession().getMapper(UserDaoAnnotation.class);
        
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
