package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.RepairsPeople;
import com.jiefeng.ssm.bean.Example.RepairsPeopleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairsPeopleMapper {
    long countByExample(RepairsPeopleExample example);

    int deleteByExample(RepairsPeopleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RepairsPeople record);

    int insertSelective(RepairsPeople record);

    List<RepairsPeople> selectByExample(RepairsPeopleExample example);

    RepairsPeople selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RepairsPeople record, @Param("example") RepairsPeopleExample example);

    int updateByExample(@Param("record") RepairsPeople record, @Param("example") RepairsPeopleExample example);

    int updateByPrimaryKeySelective(RepairsPeople record);

    int updateByPrimaryKey(RepairsPeople record);
}