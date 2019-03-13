package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Teacher;

import java.util.List;

public interface TeacherService {


    List<Teacher> getAllTeacher();

    int updateTeacher(Teacher Teacher);

    int insertTeacher(Teacher Teacher);

    int deleteTeacher(Integer id);

}
