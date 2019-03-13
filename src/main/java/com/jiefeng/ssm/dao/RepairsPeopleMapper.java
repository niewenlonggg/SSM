package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.RepairsPeople;
import java.util.List;

public interface RepairsPeopleMapper extends BaseMapper{
    int deleteByPrimaryKey(Integer id);

    int insert(RepairsPeople record);

    RepairsPeople selectByPrimaryKey(Integer id);

    List<RepairsPeople> selectAll();

    int updateByPrimaryKey(RepairsPeople record);

    RepairsPeople getInfoByLoginId(Integer loginId);
}