package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Student;
import com.jiefeng.ssm.bean.Example.StudentExample;
import com.jiefeng.ssm.dao.StudentMapper;
import com.jiefeng.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 根据学生的id进行删除
     * @param id
     * @return
     */
    @Override
    public boolean deleteStudentById(Integer id) {
        int result = studentMapper.deleteByPrimaryKey(id);
        if(result <= 0)
            return false;
        else
            return true;
    }

    /**
     * 如果参数为null，那么便会查询出所有的学生
     * 如果不为空，那么便会将根据example中的条件进行查询
     * @param studentExample
     * @return
     */
    @Override
    public List<Student> getStudentList(StudentExample studentExample) {
        List<Student> studentList = studentMapper.selectByExample(studentExample);

        return studentList;
    }

    /**
     * 根据传入的Student信息进行更新
     * @param record
     * @return
     */
    @Override
    public boolean UpdateStudentById(Student record) {

        int result = studentMapper.updateByPrimaryKeySelective(record);
        if(result <= 0)
            return false;
        else
            return true;
    }

    /**\
     * 将学生信息添加到数据库中
     * @param record
     * @return
     */
    @Override
    public boolean addStudent(Student record) {
        int result = studentMapper.insertSelective(record);
        if(result <= 0)
            return false;
        else
            return true;
    }
    
}
