package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.TbClass;
import com.jiefeng.ssm.bean.Test;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestDao {

    /**
     * 根据主键获取test
     * @param id
     * @return
     */
    Test getTestByPrimaryKey(Integer id);


    /**
     * 获取可提交的实验
     * @return
     */
    List<Test> getAllTest();


    List<Test> getAllTestAdmin();

    /**
     * 获取所有的实验根据老师的id
     * @return
     */
    List<Test> getAllTestByTeacherId(Integer id);


    /**
     * 查询相应实验对那些班级开放权限
     * @param testId
     * @return
     */
    List<TbClass> queryPermissionClass(Integer testId);


    /**
     *
     * @param teacherId
     * @param courseId
     * @return
     */
    List<Test> getAllTestByTeacherIdAndCourseId(@Param("teacherId") Integer teacherId,@Param("courseId") Integer courseId);

    /**
     * 添加一条实验
     * @param test
     * @return
     */
    boolean insertTest(Test test);


    /**
     * 更新一条实验
     * @param test
     * @return
     */
    boolean updateTest(Test test);

    /**
     * 删除一条实验
     * @param id
     * @return
     */
    boolean deleteTestByPrimaryKey(Integer id);

}
