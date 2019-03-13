package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Student;
import com.jiefeng.ssm.dao.LoginMapper;
import com.jiefeng.ssm.dao.StudentMapper;
import com.jiefeng.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {


    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private LoginMapper loginMapper;
    /**
     * 获取所有的学生
     * @return
     */
    @Override
    public List<Student> getAllStudent() {
        return studentMapper.selectAll();
    }

    @Override
    @Transactional
    public int updateStudent(Student student) {
        try{
            studentMapper.updateByPrimaryKey(student);
            if(student.getLogin() != null)
                loginMapper.updateByPrimaryKey(student.getLogin());
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return 1;
    }

    @Override
    @Transactional
    public int insertStudent(Student student) {

        int insert = loginMapper.insert(student.getLogin());
        if(insert == 1){
            int insert1 = studentMapper.insert(student);
            if(insert1 == 1){
                return 1;
            }else{
                throw new RuntimeException();
            }
        }
       return 0;
    }

    @Override
    public int deleteStudent(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }


}
