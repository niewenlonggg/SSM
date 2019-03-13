package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.BaseRole;
import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.bean.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginDao extends BaseTest {

    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectByUsername(){

        Login login = new Login();
        login.setUsername("admin");
        Login userInfo = loginMapper.selectByUsername(login);
        if(userInfo == null)
            System.out.println("kong");
        else
            System.out.println(userInfo.getPassword());

    }


    @Test
    public void testGetUserInfo(){
        BaseRole infoByLoginId = studentMapper.getInfoByLoginId(1);

        System.out.println(infoByLoginId.toString());
    }


}