package com.jiefeng.ssm.service.impl; 

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Student;
import com.jiefeng.ssm.bean.Example.StudentExample;
import com.jiefeng.ssm.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/** 
* StudentServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/05/2019</pre> 
* @version 1.0 
*/ 
public class StudentServiceImplTest extends BaseTest {

    @Autowired
    private StudentService studentService;


    /**
    * Method: deleteStudentById(Integer id) 
    */ 
    @Test
    public void testDeleteStudentById() throws Exception { 
        studentService.deleteStudentById(1);
    } 

    @Test
    public void testGetStudentList(){
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andNameLike("%o%");
        List<Student> studentList = studentService.getStudentList(studentExample);
        System.out.println(studentList);
    }

    @Test
    public void testUpdateStudentById(){
        Student student = new Student();
        student.setId(1);
        student.setName("Jerry1");
        studentService.UpdateStudentById(student);
    }

    @Test
    public void testAddStudent(){
        Student student = new Student();
        student.setName("Tom");
        student.setDepartment("软件工程");
        student.setLoginId(1);
        studentService.addStudent(student);
    }
}
