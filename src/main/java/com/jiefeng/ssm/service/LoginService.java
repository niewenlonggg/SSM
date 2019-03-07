package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Login;

import java.util.Map;

public interface LoginService {

    /**
     * 对登录信息进行验证
     * @param token
     * @return
     */
    Map<String,Object> validate(Login token, int role);
}
