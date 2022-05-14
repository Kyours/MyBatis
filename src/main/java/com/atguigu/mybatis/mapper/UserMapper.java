package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author mmystart
 * @create 2022-05-04 22:12
 */
public interface UserMapper {

    /**
     * MyBatis面向接口编程的两个一致：
     * 1、映射文件的namespace要和mapper接口的全类名保持一致
     * 2、映射文件中SQL语句的id要和mapper接口中的方法名一致
     *
     * 表--实体类--mapper接口--映射文件
     *

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();

    /**
     * 根据id查询用户信息,并将其放到一个map中
     * @param id
     * @return
     */
    Map<String,Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 获取全部的用户信息，把每条用户信息中的某个属性值作为key,把具体的用户信息作为value放到map中
     * @return
     */
    @MapKey("id")
    Map<String,Object> getAllUserToMap();

    /**
     * 插入一条数据，并获得其自增属性值
     * @param user
     */
   void insertUser(User user);
}
