package com.jiefeng.ssm.service.impl; 

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.UserService;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>$tody</pre> 
* @version 1.0 
*/ 
public class UserServiceImplTest extends BaseTest {


    @Autowired
    private UserService userService;

    /**
     * 验证用户登录信息
     * @throws Exception
     */
    @Test
    public void testValidation() throws Exception {
        if(userService == null)
            System.out.println("null");
        User user = new User();
        user.setUsername("Tom");
        user.setPassword("123456");
        Map<String, Object> validation = userService.validation(user);
        System.out.println(validation);
    }


} 
