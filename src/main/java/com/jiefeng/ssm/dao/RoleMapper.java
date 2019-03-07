package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Example.StudentExample;
import com.jiefeng.ssm.bean.Student;

import java.util.List;

public interface RoleMapper {


    List<Student> selectByExample(StudentExample example);
}
