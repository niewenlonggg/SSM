package com.jiefeng.ssm.service.impl; 

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.bean.Teacher;
import com.jiefeng.ssm.service.TeacherService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/** 
* TeacherServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/12/2019</pre> 
* @version 1.0 
*/ 
public class TeacherServiceImplTest extends BaseTest {

    @Autowired
    private TeacherService teacherService;

        /** 
    * Method: getAllTeacher() 
    */ 
    @Test
    public void testGetAllTeacher() throws Exception { 
    //TODO: Test goes here...
        List<Teacher> allTeacher = teacherService.getAllTeacher();
        for (Teacher teacher : allTeacher) {
            System.out.println(teacher);
        }

    } 
    
        /** 
    * Method: updateTeacher(Teacher Teacher) 
    */ 
    @Test
    public void testUpdateTeacher() throws Exception { 
    //TODO: Test goes here...
        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setName("谢广坤");
        teacher.setDepartment("计算机系");
        teacher.setNumber("15407396");
        teacher.setLogin(null);
        teacherService.updateTeacher(teacher);
    } 
    
        /** 
    * Method: insertTeacher(Teacher Teacher) 
    */ 
    @Test
    public void testInsertTeacher() throws Exception { 
    //TODO: Test goes here... 
    } 
    
        /** 
    * Method: deleteTeacher(Integer id) 
    */ 
    @Test
    public void testDeleteTeacher() throws Exception { 
    //TODO: Test goes here... 
    } 
    
        
    } 
