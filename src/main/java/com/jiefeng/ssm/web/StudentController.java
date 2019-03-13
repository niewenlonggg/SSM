package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Student;
import com.jiefeng.ssm.service.LoginService;
import com.jiefeng.ssm.service.StudentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private LoginService loginService;

    /**
     * 获取所有的老师信息
     * @return
     */
    @RequestMapping(value = "/getAllStudent",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllStudent(){
        Map<String,Object> modelMap = new HashMap<>();

        List<Student> studentList = studentService.getAllStudent();

        if(studentList != null){
            modelMap.put("success",true);
            modelMap.put("studentList",studentList);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }

    /**
     * 添加或者更改老师信息
     * @return
     */
    @RequestMapping(value = "/insertOrEditStudent",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> insertOrEditStudent(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        int result = 0;

        try{
            // 0 添加  1 编辑
            Integer formType = (Integer) map.get("formType");

            JSONObject object = JSONObject.fromObject(map.get("studentInfo"));
            Student student = (Student) JSONObject.toBean(object, Student.class);

            //添加操作
            if(formType == 0){
                result = studentService.insertStudent(student);
            }else{
                //更新操作

                result = studentService.updateStudent(student);
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
     * 根据ia删除老师信息
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteStudentById/{id}/{login_id}",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteStudentById(@PathVariable Integer id, @PathVariable Integer login_id){
        int studentResult = studentService.deleteStudent(id);
        int loginResult = loginService.deleteLogin(login_id);

        if(studentResult == 0 || loginResult == 0){
            throw new RuntimeException();
        } else
            return true;
    }

}
