package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.TbClass;
import com.jiefeng.ssm.dao.ClassDao;
import com.jiefeng.ssm.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ClassService")
public class ClassServiceImpl implements ClassService {


    @Autowired
    private ClassDao classDao;

    @Override
    public List<TbClass> getAllClass() {
        return classDao.getAllClass();
    }

    @Override
    public boolean insertClass(TbClass tbClass) {
        return classDao.insertClass(tbClass);
    }

    @Override
    public boolean updateClassByPrimaryKey(TbClass tbClass) {
        return classDao.updateClassByPrimaryKey(tbClass);
    }

    @Override
    public boolean deleteClassById(Integer id) {
        return classDao.deleteClassById(id);
    }
}
