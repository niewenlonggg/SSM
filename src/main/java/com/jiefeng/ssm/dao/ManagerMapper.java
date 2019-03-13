package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Manager;
import java.util.List;

public interface ManagerMapper extends BaseMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    Manager selectByPrimaryKey(Integer id);

    List<Manager> selectAll();

    int updateByPrimaryKey(Manager record);

    Manager getInfoByLoginId(Integer loginId);
}