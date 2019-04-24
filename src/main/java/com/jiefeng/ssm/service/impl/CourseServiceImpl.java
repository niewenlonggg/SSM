package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Course;
import com.jiefeng.ssm.dao.CourseDao;
import com.jiefeng.ssm.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CourseService")
public class CourseServiceImpl implements CourseService {


    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getCourseListByTeacherId(Integer teacherId) {
        return courseDao.getCourseListByTeacherId(teacherId);
    }

    @Override
    public boolean insertCourse(Course course) {
        return courseDao.insertCourse(course);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseDao.getAllCourse();
    }

    @Override
    public boolean deleteCourseByPrimaryId(Integer id) {
        return courseDao.deleteCourseByPrimaryId(id);
    }


}
