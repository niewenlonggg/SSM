package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.TbClass;

import java.util.List;

public interface ClassDao {

    List<TbClass> getAllClass();

    boolean insertClass(TbClass tbClass);

    boolean updateClassByPrimaryKey(TbClass tbClass);

    boolean deleteClassById(Integer id);


}
