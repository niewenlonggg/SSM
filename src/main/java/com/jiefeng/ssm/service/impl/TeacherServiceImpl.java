package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Teacher;
import com.jiefeng.ssm.bean.Teacher;
import com.jiefeng.ssm.dao.LoginMapper;
import com.jiefeng.ssm.dao.TeacherMapper;
import com.jiefeng.ssm.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("TeacherService")
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private LoginMapper loginMapper;

    /**
     * 获取所有的学生
     * @return
     */
    @Override
    public List<Teacher> getAllTeacher() {
        return teacherMapper.selectAll();
    }

    @Override
    @Transactional
    public int updateTeacher(Teacher teacher) {
        System.out.println("teacher: " + teacher);
        try{
            teacherMapper.updateByPrimaryKey(teacher);
            if(teacher.getLogin() != null)
                loginMapper.updateByPrimaryKey(teacher.getLogin());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return 1;
    }

    @Override
    @Transactional
    public int insertTeacher(Teacher teacher) {
        int insert = loginMapper.insert(teacher.getLogin());
        System.out.println(teacher.getLogin().getId());
        if(insert == 1){
            int insert1 = teacherMapper.insert(teacher);
            if(insert1 == 1){
                return 1;
            }else{
                throw new RuntimeException();
            }
        }
        return 0;
    }

    @Override
    public int deleteTeacher(Integer id) {
        return teacherMapper.deleteByPrimaryKey(id);
    }
}
