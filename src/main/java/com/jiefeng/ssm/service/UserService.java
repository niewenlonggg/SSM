package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    Map<String,Object> validation(User token);


    List<User> getUserInfoByType(Integer type);

    boolean deleteUserByPrimaryKey(Integer id);

    boolean updateUser(User user);

    boolean insertUser(User user);

    boolean adminValidation(User token);
}
