package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.TbClass;
import com.jiefeng.ssm.service.ClassService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@RequestMapping("/class")
@Controller
public class ClassController {

    @Autowired
    public ClassService classService;



    @RequestMapping("/getAllClass")
    @ResponseBody
    private List<TbClass> getAllClass(){
        return classService.getAllClass();
    }


    @RequestMapping("/addOrEditClass")
    @ResponseBody
    private boolean addOrEditClass(@RequestBody Map map){
        boolean b = false;
        try{
            JSONObject object = JSONObject.fromObject(map.get("Class"));

            System.out.println(object);
            TbClass tbClass = (TbClass) JSONObject.toBean(object, TbClass.class);
            System.out.println(tbClass);
            boolean addOrEdit = (boolean) map.get("addOrEdit");

            //为真表示添加
            if(addOrEdit){
                b = classService.insertClass(tbClass);
            }else{
                b = classService.updateClassByPrimaryKey(tbClass);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return b;
    }

    @RequestMapping("/deleteClassById/{id}")
    @ResponseBody
    private boolean deleteClassById(@PathVariable Integer id){
        return classService.deleteClassById(id);
    }

}
