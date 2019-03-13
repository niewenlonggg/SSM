package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Teacher;
import java.util.List;

public interface TeacherMapper extends BaseMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    Teacher selectByPrimaryKey(Integer id);

    List<Teacher> selectAll();

    int updateByPrimaryKey(Teacher record);

    Teacher getInfoByLoginId(Integer loginId);
}