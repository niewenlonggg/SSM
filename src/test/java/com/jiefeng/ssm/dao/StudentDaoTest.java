package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Student;
import com.jiefeng.ssm.bean.Teacher;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentDaoTest extends BaseTest {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void testGetAllStudent(){
//        List<Student> studentList = studentMapper.selectAll();
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
        List<Teacher> teachers = teacherMapper.selectAll();
        for (Teacher teacher : teachers) {
            System.out.println(teacher);

        }

    }
}