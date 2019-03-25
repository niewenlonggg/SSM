package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.TbClass;
import com.jiefeng.ssm.bean.TestClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestClassDao {

    boolean batchInsert(@Param("testId") Integer testId, @Param("classList")List<Integer> classList);

    /**
     * 删除这条实验的所有允许提交班级，然后重新赋值
     * @param testId
     * @return
     */
    int deleteTestPermission(Integer testId);

    List<TestClass> getAllClass();

    boolean insertClass(TestClass testClass);

    List<TbClass> getClassByPrimaryKey(Integer id);

}
