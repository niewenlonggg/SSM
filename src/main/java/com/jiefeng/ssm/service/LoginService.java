package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Login;

import java.util.Map;

public interface LoginService {

    Map<String,Object> adminValidation(Login token);

    Map<String,Object> validation(int role,Login token);

    int deleteLogin(Integer id);

    Map<String,Object> updateAdminPassword(String oldPassword, String newPassword);
}
