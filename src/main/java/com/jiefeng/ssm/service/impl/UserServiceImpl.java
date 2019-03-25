package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.dao.UserDao;
import com.jiefeng.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    /**
     * 验证用户登录信息
     * @param token
     * @return
     */
    @Override
    public Map<String,Object> validation(User token) {

        Map<String,Object> modelMap = new HashMap<>();
        User databaseUserInfo = null;
        try{
            //查询用户信息
            databaseUserInfo = userDao.getUserByUsername(token.getUsername());

            //如果databaseUserInfo为null说明没有此用户
            if(databaseUserInfo == null){
                modelMap.put("success",false);
                modelMap.put("errMsg","没有此用户");
                return modelMap;
            }

            //有此用户但是密码错误
            if(!databaseUserInfo.getPassword().equals(token.getPassword())){
                modelMap.put("success",false);
                modelMap.put("errMsg","请输入正确的密码");
                return modelMap;
            }
        }catch (Exception e){
            e.printStackTrace();
        }


        //验证成功，返回用户的信息
        modelMap.put("user",databaseUserInfo);
        modelMap.put("success",true);

        return modelMap;
    }

    @Override
    public List<User> getUserInfoByType(Integer type) {
        return userDao.getUserByType(type);
    }

    @Override
    public boolean deleteUserByPrimaryKey(Integer id) {
        return userDao.deleteUserByPrimaryId(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public boolean adminValidation(User token) {
        Map<String,Object> modelMap = new HashMap<>();
        try{
            User user = userDao.adminValidation();
            if(user.getUsername().equals(token.getUsername()) && user.getPassword().equals(token.getPassword()))
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


}
