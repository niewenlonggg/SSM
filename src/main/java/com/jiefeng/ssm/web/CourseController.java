package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Course;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.CourseService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping(value = "/getAllCourseByTeacherId",method = RequestMethod.GET)
    @ResponseBody
    private List<Course> getAllCourseByTeacherId(@RequestParam("teacherId") Integer id){
        return courseService.getCourseListByTeacherId(id);
    }

    @RequestMapping(value = "/deleteCourseByPrimaryId",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteCourseByPrimaryId(@RequestParam("courseId") Integer id){
        return courseService.deleteCourseByPrimaryId(id);
    }


    @RequestMapping(value = "/getAllCourse",method = RequestMethod.GET)
    @ResponseBody
    private List<Course> getAllCourse(){
        return courseService.getAllCourse();
    }

    @RequestMapping(value = "/insertCourse",method = RequestMethod.POST)
    @ResponseBody
    private boolean insertCourse(@RequestBody Map map){
        try{
            Integer teacherId = (Integer) map.get("teacherId");
            JSONObject object = JSONObject.fromObject(map.get("course"));
            Course course = (Course) JSONObject.toBean(object,Course.class);
            User user = new User();
            user.setId(teacherId);

            course.setTeacher(user);

            boolean b = courseService.insertCourse(course);
            if(b)
                return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }




}
