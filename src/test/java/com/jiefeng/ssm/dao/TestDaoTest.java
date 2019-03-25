package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Course;
import com.jiefeng.ssm.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestDaoTest extends BaseTest {


    @Autowired
    private TestDao testDao;

    @Test
    public void testGetAllTest(){
        List<com.jiefeng.ssm.bean.Test> allTest = testDao.getAllTestByTeacherId(1);
        for (com.jiefeng.ssm.bean.Test test : allTest) {
            System.out.println(test.getTitle());
        }
    }

    @Test
    public void getAllTestByTeacherIdAndCourseId(){
        List<com.jiefeng.ssm.bean.Test> testList = testDao.getAllTestByTeacherIdAndCourseId(1, 3);
        for (com.jiefeng.ssm.bean.Test test : testList) {
            System.out.println(test);
        }
    }

    @Test
    public void testInsertTest(){
        com.jiefeng.ssm.bean.Test test = new com.jiefeng.ssm.bean.Test();

        test.setTitle("关于实验布线");
        test.setStatus(false);
        test.setTestDesc("综合实验布线");
        User user = new User();
        user.setId(3);
        test.setTeacherId(user);
        Course course = new Course();
        course.setId(3);
        test.setCourse(course);
        testDao.insertTest(test);
    }


    @Test
    public void testUpdateTest(){
        com.jiefeng.ssm.bean.Test updateTest = new com.jiefeng.ssm.bean.Test();
        updateTest.setId(7);
        updateTest.setTitle("这是测试更新功能好不好用");
        updateTest.setStatus(true);
        boolean b = testDao.updateTest(updateTest);
        System.out.println(b);
    }


    @Test
    public void testGetAllTestAvailable(){
        List<com.jiefeng.ssm.bean.Test> allTest = testDao.getAllTest();
        for (com.jiefeng.ssm.bean.Test test : allTest) {
            System.out.println(test);
        }
    }
}
