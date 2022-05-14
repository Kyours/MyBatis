package com.atguigu.mybatis;

import com.atguigu.mybatis.mapper.EmpMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.pojo.EmpExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author mmystart
 * @create 2022-05-13 0:36
 */
public class TestMBG {

    @Test
    public void mbgTest() {
        InputStream resource = null;
        try {
            resource = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(resource);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            PageHelper.startPage(1,3);
            List<Emp> emps = mapper.selectByExample(null);
            PageInfo<Emp> pageInfo = new PageInfo<>(emps,5);
            emps.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hello git");
        System.out.println("Hello git2");
    }
}
