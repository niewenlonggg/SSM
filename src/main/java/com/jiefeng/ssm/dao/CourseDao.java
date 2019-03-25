package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Course;

import java.util.List;

public interface CourseDao {

    /**
     * 根据id查询对应的course
     * @param id
     * @return
     */
    Course getCourseByPrimaryKey(Integer id);

    /**
     * 根据教师的id获取其对应的所有的课程
     * @param id
     * @return
     */
    List<Course> getCourseListByTeacherId(Integer id);


    /**
     * 添加一个课程
     * @param course
     * @return
     */
    boolean insertCourse(Course course);

    /**
     * 获取所有的课程
     * @return
     */
    List<Course> getAllCourse();
}
