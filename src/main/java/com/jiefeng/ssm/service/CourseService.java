package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Course;

import java.util.List;

public interface CourseService {


    List<Course> getCourseListByTeacherId(Integer teacherId);


    boolean insertCourse(Course course);

    List<Course> getAllCourse();
}
