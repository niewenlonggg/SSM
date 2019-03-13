package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Teacher;
import com.jiefeng.ssm.service.LoginService;
import com.jiefeng.ssm.service.TeacherService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private LoginService loginService;

    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "/getAllTeacher",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllTeacher(){
        Map<String,Object> modelMap = new HashMap<>();

        List<Teacher> TeacherList = teacherService.getAllTeacher();

        if(TeacherList != null){
            modelMap.put("success",true);
            modelMap.put("TeacherList",TeacherList);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }

    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "/insertOrEditTeacher",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> insertOrEditTeacher(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        int result = 0;

        try{
            // 0 添加  1 编辑
            Integer formType = (Integer) map.get("formType");

            JSONObject object = JSONObject.fromObject(map.get("TeacherInfo"));
            Teacher Teacher = (Teacher) JSONObject.toBean(object, Teacher.class);

            //添加操作
            if(formType == 0){
                result = teacherService.insertTeacher(Teacher);
            }else{
                //更新操作

                result = teacherService.updateTeacher(Teacher);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result != 0){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }

    /**
     * 根据ia删除学生数据
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteTeacherById/{id}/{login_id}",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteTeacherById(@PathVariable Integer id, @PathVariable Integer login_id){
        int TeacherResult = teacherService.deleteTeacher(id);
        int loginResult = loginService.deleteLogin(login_id);

        if(TeacherResult == 0 || loginResult == 0){
            throw new RuntimeException();
        } else
            return true;
    }
    
}
