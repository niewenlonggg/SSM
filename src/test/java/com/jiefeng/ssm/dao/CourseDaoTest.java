package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Course;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseDaoTest extends BaseTest {


    @Autowired
    private CourseDao courseDao;

    @Test
    public void testGetCourseByPrimaryKey(){
        Course courseByPrimaryKey = courseDao.getCourseByPrimaryKey(1);
        System.out.println(courseByPrimaryKey);
    }
}
