package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Manager;

import java.util.List;

public interface BaseMapper<T> {
    int deleteByPrimaryKey(Integer id);

    int insert(T record);

    T selectByPrimaryKey(Integer id);

    List<Manager> selectAll();

    int updateByPrimaryKey(T record);

    T getInfoByLoginId(T loginId);
}
