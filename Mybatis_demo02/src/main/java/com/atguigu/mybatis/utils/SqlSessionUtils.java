package com.atguigu.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author mmystart
 * @create 2022-05-11 1:58
 */
public class SqlSessionUtils {

    public static SqlSession getSqlSession(){
        try {
            InputStream resource = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = sqlSessionFactoryBuilder.build(resource);
            SqlSession sqlSession = build.openSession(true);
            return sqlSession;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
