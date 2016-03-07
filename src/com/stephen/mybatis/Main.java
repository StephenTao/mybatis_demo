package com.stephen.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.stephen.mybatis.model.User;

/**
 * 
 * @author Stephen Huang
 * 
 */
public class Main {

    public static void main(String[] args) {
        //mybatis的配置文件
        String resource = "mybatis-config.xml";
        //获取session，两种方式
        SqlSession session = getSqlSession1(resource);
//        SqlSession session = getSqlSession2(resource);

        //根据映射sql的标识字符串执行CRUD
        String add = "com.stephen.mybatis.model.UserMapper.add";
        String get = "com.stephen.mybatis.model.UserMapper.get";
        String update = "com.stephen.mybatis.model.UserMapper.update";
        String delete = "com.stephen.mybatis.model.UserMapper.delete";
        
        //add test
        User user = new User();
        user.setName("stephen");
        user.setAge(18);
        session.insert(add, user);
        System.out.println("add user:" + user);
        
        //get test
        user = session.selectOne(get, user.getId());
        System.out.println("get user:" + user);
        //update test
        user.setAge(28);
        session.update(update, user);
        System.out.println("update user age=28:" + user);
        //delete test
        System.out.println("delete user id:" + user.getId());
        session.delete(delete, user.getId());
        System.out.println(session.selectOne(get, user.getId()));
    }

    public static SqlSession getSqlSession1(String resource) {
        SqlSession session = null;
        try {
            //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
            Reader reader = Resources.getResourceAsReader(resource);
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建能执行映射文件中sql的sqlSession
            session = sessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return session;
    }

    public static SqlSession getSqlSession2(String resource) {
        SqlSession session = null;
        try {
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            InputStream is = Main.class.getClassLoader().getResourceAsStream(resource);
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            //创建能执行映射文件中sql的sqlSession
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
