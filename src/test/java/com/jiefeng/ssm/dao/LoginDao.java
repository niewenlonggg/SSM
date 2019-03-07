package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Login;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginDao extends BaseTest {

    @Autowired
    private LoginMapper loginMapper;

    @Test
    public void testLoginInsert(){
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("123456");
        int result = loginMapper.insert(login);
        System.out.println(result);
    }
}