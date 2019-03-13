package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.BaseRole;
import com.jiefeng.ssm.bean.Login;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    Login selectByPrimaryKey(Integer id);

    List<Login> selectAll();

    int updateByPrimaryKey(Login record);

    /**
     * 根据用户名查询用户信息
     * @param record
     * @return
     */
    Login selectByUsername(Login record);

    /**
     * 获取
     * @param loginId
     * @return
     */
    BaseRole getUserInfo(@Param("role") Integer role, @Param("loginId") Integer loginId);
}