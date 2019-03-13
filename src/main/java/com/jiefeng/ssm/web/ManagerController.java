package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Manager;
import com.jiefeng.ssm.service.LoginService;
import com.jiefeng.ssm.service.ManagerService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/managerPeople")
public class ManagerController {


    @Autowired
    private ManagerService managerService;

    @Autowired
    private LoginService loginService;
    
    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "/getAllManagerPeople",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllManagerPeople(){
        Map<String,Object> modelMap = new HashMap<>();

        List<Manager> ManagerPeopleList = managerService.getAllManager();

        if(ManagerPeopleList != null){
            modelMap.put("success",true);
            modelMap.put("ManagerPeopleList",ManagerPeopleList);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }

    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "/insertOrEditManagerPeople",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> insertOrEditManagerPeople(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        int result = 0;

        try{
            // 0 添加  1 编辑
            Integer formType = (Integer) map.get("formType");

            JSONObject object = JSONObject.fromObject(map.get("ManagerPeopleInfo"));
            Manager Manager = (Manager) JSONObject.toBean(object, Manager.class);
            System.out.println(Manager);
            //添加操作
            if(formType == 0){
                result = managerService.insertManager(Manager);
            }else{
                //更新操作

                result = managerService.updateManager(Manager);
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
    @RequestMapping(value = "/deleteManagerPeopleById/{id}/{login_id}",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteManagerPeopleById(@PathVariable Integer id, @PathVariable Integer login_id){
        int ManagerPeopleResult = managerService.deleteManager(id);
        int loginResult = loginService.deleteLogin(login_id);

        if(ManagerPeopleResult == 0 || loginResult == 0){
            throw new RuntimeException();
        } else
            return true;
    }
}
