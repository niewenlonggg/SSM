package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.LaboratoryManager;
import com.jiefeng.ssm.bean.LaboratoryManagerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LaboratoryManagerMapper {
    long countByExample(LaboratoryManagerExample example);

    int deleteByExample(LaboratoryManagerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LaboratoryManager record);

    int insertSelective(LaboratoryManager record);

    List<LaboratoryManager> selectByExample(LaboratoryManagerExample example);

    LaboratoryManager selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LaboratoryManager record, @Param("example") LaboratoryManagerExample example);

    int updateByExample(@Param("record") LaboratoryManager record, @Param("example") LaboratoryManagerExample example);

    int updateByPrimaryKeySelective(LaboratoryManager record);

    int updateByPrimaryKey(LaboratoryManager record);
}