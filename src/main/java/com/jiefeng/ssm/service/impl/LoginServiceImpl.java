package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.BaseRole;
import com.jiefeng.ssm.bean.Example.StudentExample;
import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.bean.Example.LoginExample;
import com.jiefeng.ssm.dao.LoginMapper;
import com.jiefeng.ssm.dao.RepairsPeopleMapper;
import com.jiefeng.ssm.dao.StudentMapper;
import com.jiefeng.ssm.dao.TeacherMapper;
import com.jiefeng.ssm.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private RepairsPeopleMapper repairsPeopleMapper;

    @Override
    public Map<String,Object> validate(Login token ,int role) {
        Map<String,Object> map = new HashMap<>();

        //获取前端传过来的用户名
        String username = token.getUsername();

        //使用example进行查询
        LoginExample usernameExample = new LoginExample();
        LoginExample.Criteria usernameExampleCriteria = usernameExample.createCriteria();
        //where username = ?
        usernameExampleCriteria.andUsernameEqualTo(username);

        //由于loginMapper.selectByExample返回List<Login>
        List<Login> data_token =  loginMapper.selectByExample(usernameExample);

        //如果没有返回值
        if(data_token == null){
            map.put("success",false);
            map.put("errMsg","没有此用户");
            return map;
        }
        //密码不同
        if(!token.getPassword().equals(data_token.get(0).getPassword())){
            map.put("success",false);
            map.put("errMsg","请输入正确的用户名或者密码");
            return map;
        }

        int logId = data_token.get(0).getId();

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
        studentExampleCriteria.andLoginIdEqualTo(logId);

        BaseRole userInfo = new BaseRole();
        switch (role){
            case 0: userInfo = (BaseRole) studentMapper.selectByExample(studentExample);break;
        }

        map.put("success",true);
        map.put("userInfo",userInfo);
        return map;
    }

/*
    @Override
    public Map<String,Object> validate(Login token ,int role) {
        Map<String,Object> map = new HashMap<>();

        //获取前端传过来的用户名
        String username = token.getUsername();

        //使用example进行查询
        LoginExample usernameExample = new LoginExample();
        LoginExample.Criteria usernameExampleCriteria = usernameExample.createCriteria();
        //where username = ?
        usernameExampleCriteria.andUsernameEqualTo(username);

        //由于loginMapper.selectByExample返回List<Login>
        List<Login> data_token =  loginMapper.selectByExample(usernameExample);

        //如果没有返回值
        if(data_token == null){
            map.put("success",false);
            map.put("errMsg","没有此用户");
            return map;
        }
        //密码不同
        if(!token.getPassword().equals(data_token.get(0).getPassword())){
            map.put("success",false);
            map.put("errMsg","请输入正确的用户名或者密码");
            return map;
        }

        int logId = data_token.get(0).getId();

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria studentExampleCriteria = studentExample.createCriteria();
        studentExampleCriteria.andLoginIdEqualTo(logId);

        BaseRole userInfo = new BaseRole();
        switch (role){
            case 0: userInfo = (BaseRole) studentMapper.selectByExample(studentExample);break;
        }

        map.put("success",true);
        map.put("userInfo",userInfo);
        return map;
    }

    */
}
