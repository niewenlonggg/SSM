package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.BaseRole;
import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.bean.RepairsPeople;
import com.jiefeng.ssm.dao.*;
import com.jiefeng.ssm.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginMapper loginMapper;
    @Autowired
    private ManagerMapper managerMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RepairsPeopleMapper repairsPeopleMapper;


    @Override
    public Map<String, Object> adminValidation(Login token) {
        Map<String,Object> validationInfo = new HashMap<>();

        Login login = loginMapper.selectByPrimaryKey(16);
        if(login == null
                || !login.getPassword().equals(token.getPassword())
                || !login.getUsername().equals(token.getUsername())){

            validationInfo.put("errMsg","请输入正确的登录名或者密码");
            validationInfo.put("success",false);
        }else{
            validationInfo.put("success",true);
        }
        return validationInfo;
    }

    /**
     * 验证用户信息
     * @param token
     * @return
     */
    @Override
    public Map<String, Object> validation(int role,Login token) {
        Map<String,Object> validationInfo = new HashMap<>();

        Login  realToken = loginMapper.selectByUsername(token);

        if(realToken == null){
            validationInfo.put("success",false);
            validationInfo.put("errMsg","没有此用户");
            return validationInfo;
        }

        if(!realToken.getPassword().equals(token.getPassword())){
            validationInfo.put("success",false);
            validationInfo.put("errMsg","用户名或者密码错误");
            return validationInfo;
        }
        BaseRole userInfo = new BaseRole();

        switch (role){
            case 0: userInfo = studentMapper.getInfoByLoginId(realToken.getId());break;
            case 1: userInfo = teacherMapper.getInfoByLoginId(realToken.getId());break;
            case 2: userInfo = managerMapper.getInfoByLoginId(realToken.getId());break;
            case 3: userInfo = repairsPeopleMapper.getInfoByLoginId(realToken.getId());break;
        }
        if(userInfo == null){
            validationInfo.put("success",false);
            validationInfo.put("errMsg","请输入正确的用户类型");
            return validationInfo;
        }
        validationInfo.put("success",true);
        validationInfo.put("userInfo",userInfo);

        logger.info(userInfo.toString());

        return validationInfo;
    }

    @Override
    public int deleteLogin(Integer id) {
        return loginMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Map<String,Object> updateAdminPassword(String oldPassword, String newPassword) {

        Map<String, Object> modelMap = new HashMap<>();

        Login loginInfo = loginMapper.selectByPrimaryKey(16);
        if(!oldPassword.equals(loginInfo.getPassword())){
            modelMap.put("success",false);
            modelMap.put("errMsg","旧密码输入错误");
        }else{
            Login login = new Login();
            login.setId(16);
            login.setPassword(newPassword);
            int i = loginMapper.updateByPrimaryKey(login);
            if(i > 0){
                modelMap.put("success",true);
            }
        }
        return modelMap;
    }

}
