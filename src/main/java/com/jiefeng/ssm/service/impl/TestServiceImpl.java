package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Test;
import com.jiefeng.ssm.dao.TestClassDao;
import com.jiefeng.ssm.dao.TestDao;
import com.jiefeng.ssm.service.TestService;
import com.jiefeng.ssm.util.ImageUtil;
import com.jiefeng.ssm.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service("TestService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Autowired
    private TestClassDao testClassDao;

    /**
     * 根据老师的id查询其所有的实验
     * @param teacherId
     * @return
     */
    @Override
    public List<Test> getAllTestByTeacherId(Integer teacherId) {
        return testDao.getAllTestByTeacherId(teacherId);
    }

    @Override
    public List<Test> getAllTestByTeacherIdAndCourseId(Integer teacherId, Integer courseId) {
        return testDao.getAllTestByTeacherIdAndCourseId(teacherId,courseId);
    }

    @Override
    @Transactional
    public Boolean insertOrEditTest(Test test,List<Integer> permissionList,boolean addOrEdit) {

        try{
            //如果为添加操作
            if(addOrEdit){
                boolean insertResult = testDao.insertTest(test);
                if(insertResult){
                    System.out.println("TestId :   " + test.getId());
                    //将所有的可允许提交的班级插入到数据库中，并获取返回结果
                    boolean permissionInsertResult = testClassDao.batchInsert(test.getId(), permissionList);
                    if(permissionInsertResult)
                            return true;
                }
            }else{
                //如果为更新操作

                //先更新基本的实验数据
                testDao.updateTest(test);
                //然后将以前的班级提交权限删除
                testClassDao.deleteTestPermission(test.getId());
                //重新添加新的班级权限
                boolean newBatchInsertResult= testClassDao.batchInsert(test.getId(), permissionList);
                if(newBatchInsertResult)
                    return true;
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
        return false;
    }



    @Override
    public List<Test> getAllTest() {
        return testDao.getAllTest();
    }

    @Override
    public List<Test> getAllTestAdmin() {
        return testDao.getAllTestAdmin();
    }


    /**
     * 上传实验说明视频
     * @param request
     * @return
     */
    @Override
    public boolean uploadVideo(HttpServletRequest request) {
        try{
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> files = multipartRequest.getFiles("testVideo");

            Integer testId = Integer.parseInt(request.getParameter("testId"));
            System.out.println(testId);

            String ImageUrl = PathUtil.getTestVideoUrl(testId);
            String url = ImageUtil.generateNormalImg(files.get(0), ImageUrl);

            Test test = new Test();
            test.setId(testId);
            test.setVideoUrl(url);

            boolean b = testDao.updateVideoUrl(test);
            return b;

        }catch (Exception e){
            e.printStackTrace();
        }


        return false;
    }


}
