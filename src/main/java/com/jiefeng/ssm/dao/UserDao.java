package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.User;

import java.util.List;

public interface UserDao {


    /**
     * 根据用户名获取用户登录信息以及用户信息
     * @param id
     * @return
     */
    User getUserByUsername(String id);

    /**
     * 根据primary key 获取id
     * @param id
     * @return
     */
    User getUserByPrimaryKey(Integer id);

    /**
     * 获取用户信息
     * @param type
     * @return
     */
    List<User> getUserByType(Integer type);


    boolean deleteUserByPrimaryId(Integer id);


    boolean updateUser(User user);

    boolean insertUser(User user);

    User adminValidation();

}
