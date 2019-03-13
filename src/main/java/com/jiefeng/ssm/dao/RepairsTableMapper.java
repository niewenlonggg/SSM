package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.RepairsTable;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;

public interface RepairsTableMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(RepairsTable record);

    RepairsTable selectByPrimaryKey(Integer id);

    List<RepairsTable> selectAll();

    int updateByPrimaryKey(RepairsTable record);

    List<RepairsTable> getFirstTable();

    List<RepairsTable> selectTableMore();

    List<RepairsTable> selectHistory(RepairsTable repairsTable);

    List<RepairsTable> selectRepairing(RepairsTable repairsTable);
}