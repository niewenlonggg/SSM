package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TestService {

    List<Test> getAllTestByTeacherId(Integer teacherId);

    List<Test> getAllTestByTeacherIdAndCourseId(Integer teacherId,Integer courseId);

    Boolean insertOrEditTest(Test test,List<Integer> permissionList,boolean addOrEdit);

    List<Test> getAllTest();

    List<Test> getAllTestAdmin();


    boolean uploadVideo(HttpServletRequest request);

}
