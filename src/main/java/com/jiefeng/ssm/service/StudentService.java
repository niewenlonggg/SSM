package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Student;
import com.jiefeng.ssm.bean.Example.StudentExample;

import java.util.List;

public interface StudentService {

    /**
     * 根据学生的id进行删除
     * @param id
     * @return
     */
    boolean deleteStudentById(Integer id);

    /**
     * 实现查询学生的功能，如果参数为null的话便查询所有学生
     * 如果不为空，那么便会根据example中的查询条件进行查询
     * @param studentExample
     * @return
     */
    List<Student> getStudentList(StudentExample studentExample);

    /**
     * 根据学生id进行更改学生信息
     * @param record
     * @return
     */
    boolean UpdateStudentById(Student record);

    /**
     * 添加学生功能
     * @param record
     * @return
     */
    boolean addStudent(Student record);
}
