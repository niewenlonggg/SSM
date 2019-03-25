package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoTest extends BaseTest {

    @Autowired
    private UserDao userDao;


    @Test
    public void testGetUserByUsername(){
        User jackMa = userDao.getUserByUsername("Tom");
        System.out.println(jackMa);
    }

    @Test
    public void testGetUserByPrimaryKey(){
        User userByPrimaryKey = userDao.getUserByPrimaryKey(1);
        System.out.println(userByPrimaryKey);
    }

    @Test
    public void testGetClassById(){
    }
}
