package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.TbClass;

import java.util.List;

public interface ClassService {

    List<TbClass> getAllClass();

    boolean insertClass(TbClass tbClass);

    boolean updateClassByPrimaryKey(TbClass tbClass);

    boolean deleteClassById(Integer id);
}
