package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.BaseRole;
import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.bean.Example.LoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LoginMapper {
    long countByExample(LoginExample example);

    int deleteByExample(LoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Login record);

    int insertSelective(Login record);

    List<Login> selectByExample(LoginExample example);

    Login selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Login record, @Param("example") LoginExample example);

    int updateByExample(@Param("record") Login record, @Param("example") LoginExample example);

    int updateByPrimaryKeySelective(Login record);

    int updateByPrimaryKey(Login record);


}