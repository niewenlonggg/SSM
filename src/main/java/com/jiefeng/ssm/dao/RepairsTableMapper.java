package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.RepairsTable;
import com.jiefeng.ssm.bean.Example.RepairsTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RepairsTableMapper {
    long countByExample(RepairsTableExample example);

    int deleteByExample(RepairsTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RepairsTable record);

    int insertSelective(RepairsTable record);

    List<RepairsTable> selectByExample(RepairsTableExample example);

    RepairsTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RepairsTable record, @Param("example") RepairsTableExample example);

    int updateByExample(@Param("record") RepairsTable record, @Param("example") RepairsTableExample example);

    int updateByPrimaryKeySelective(RepairsTable record);

    int updateByPrimaryKey(RepairsTable record);
}