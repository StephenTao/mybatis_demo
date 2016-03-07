package com.stephen.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.stephen.mybatis.dao.UserDao;
import com.stephen.mybatis.model.User;
import com.stephen.mybatis.util.SpringUtil;

public class TestSpring {

    /**
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) ctx.getBean("userDao");
        UserDao userDao = (UserDao) SpringUtil.getBean("userDao");
        User user = userDao.get(1);
        System.out.println(user);
        //http://haohaoxuexi.iteye.com/blog/1843309
        //http://www.cnblogs.com/jyh317/p/3834142.html

    }

}
