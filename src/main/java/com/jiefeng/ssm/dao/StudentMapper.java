package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Student;
import java.util.List;

public interface StudentMapper extends BaseMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    Student selectByPrimaryKey(Integer id);

    List<Student> selectAll();

    int updateByPrimaryKey(Student record);

    Student getInfoByLoginId(Integer loginId);
}