package com.jiefeng.ssm.web;


import com.jiefeng.ssm.bean.Course;
import com.jiefeng.ssm.bean.Test;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.TestService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/test")
@Controller
public class TestController  {

    Logger logger  = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;


    @RequestMapping(value = "/getAllTestAdmin",method = RequestMethod.GET)
    @ResponseBody
    public List<Test> getAllTestAdmin(){
        return testService.getAllTestAdmin();
    }

    @RequestMapping(value = "/getAllTestAvailable",method = RequestMethod.GET)
    @ResponseBody
    public List<Test> getAllTestAvailable(){
        return testService.getAllTest();
    }

    /**
     * 根据教师的id查询其所有的实验
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAllTestByTeacherId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllTestByTeacherId(@RequestParam("teacherId") Integer id){
        Map<String ,Object> modelMap = new HashMap<>();

        List<Test> allTestByTeacherId = testService.getAllTestByTeacherId(id);
        modelMap.put("success",true);
        modelMap.put("teacherTestList",allTestByTeacherId);

        return modelMap;
    }


    /**
     * 根据教师的id和课程id查询其所有的实验
     * @param teacherId
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/getAllTestByTeacherIdAndCourseId",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllTestByTeacherIdAndCourseId(@RequestParam("teacherId") Integer teacherId,
                                                    @RequestParam("courseId") Integer courseId){
        Map<String ,Object> modelMap = new HashMap<>();

        List<Test> allTestByTeacherId = testService.getAllTestByTeacherIdAndCourseId(teacherId,courseId);
        modelMap.put("success",true);
        modelMap.put("courseTestList",allTestByTeacherId);

        return modelMap;
    }


    @RequestMapping(value = "/insertOrEditTest",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertOrEditTest(@RequestBody Map map) {
        Map<String, Object> modelMap = new HashMap<>();
        Boolean aBoolean = false;
        try {
            //判断是添加还是更新
            boolean addOrEdit = (boolean) map.get("addOrEdit");

            //获取基本的实验信息
            JSONObject testInfo = JSONObject.fromObject(map.get("TestInfo"));
            Integer teacherId = (Integer) map.get("teacherId");
            Integer courseId = (Integer) map.get("courseId");

            List<Integer> permissionList = (List<Integer>) map.get("permissionClassList");
            logger.info("permissionList: " + permissionList);

            System.out.println(testInfo);
            //将基本的信息转化到bean中
            Test test = (Test) JSONObject.toBean(testInfo, Test.class);

            //设置实验的拥有者
            User user = new User();
            user.setId(teacherId);

            //设置实验属于那个课程
            Course course = new Course();
            course.setId(courseId);

            //设置到bean中
            test.setCourse(course);
            test.setTeacherId(user);
            //插入
           aBoolean = testService.insertOrEditTest(test,permissionList,addOrEdit);

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (aBoolean)
            modelMap.put("success", true);
        else
            modelMap.put("success", false);
        return modelMap;
    }
}
