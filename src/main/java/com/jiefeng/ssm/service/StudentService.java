package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Student;

import java.util.List;

public interface StudentService {


    List<Student> getAllStudent();

    int updateStudent(Student student);

    int insertStudent(Student student);

    int deleteStudent(Integer id);


}
