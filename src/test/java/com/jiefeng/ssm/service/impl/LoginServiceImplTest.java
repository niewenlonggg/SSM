package com.jiefeng.ssm.service.impl; 

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.service.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

/** 
* LoginServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/08/2019</pre> 
* @version 1.0 
*/ 
public class LoginServiceImplTest extends BaseTest {

    @Autowired
    private LoginService loginService;

    /**
    * Method: validation(Login token) 
    */ 
    @Test
    public void testValidation() throws Exception {
        Login login = new Login();
        login.setUsername("root");
        login.setPassword("123456");
        Map<String, Object> validation = loginService.validation(1,login);
        System.out.println(validation);
    } 
    
        
    } 
