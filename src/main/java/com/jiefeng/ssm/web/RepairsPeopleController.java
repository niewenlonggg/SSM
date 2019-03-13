package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.RepairsPeople;
import com.jiefeng.ssm.service.LoginService;
import com.jiefeng.ssm.service.RepairsPeopleService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/repairs")
public class RepairsPeopleController  {

    @Autowired
    private RepairsPeopleService repairsPeopleService;

    @Autowired
    private LoginService loginService;

    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "/getAllRepairsPeople",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllRepairsPeople(){
        Map<String,Object> modelMap = new HashMap<>();

        List<RepairsPeople> RepairsPeopleList = repairsPeopleService.getAllRepairsPeople();

        if(RepairsPeopleList != null){
            modelMap.put("success",true);
            modelMap.put("RepairsPeopleList",RepairsPeopleList);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }

    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "/insertOrEditRepairsPeople",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> insertOrEditRepairsPeople(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        int result = 0;

        try{
            // 0 添加  1 编辑
            Integer formType = (Integer) map.get("formType");

            JSONObject object = JSONObject.fromObject(map.get("RepairsPeopleInfo"));
            RepairsPeople RepairsPeople = (RepairsPeople) JSONObject.toBean(object, RepairsPeople.class);

            //添加操作
            if(formType == 0){
                result = repairsPeopleService.insertRepairsPeople(RepairsPeople);
            }else{
                //更新操作

                result = repairsPeopleService.updateRepairsPeople(RepairsPeople);
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
    @RequestMapping(value = "/deleteRepairsPeopleById/{id}/{login_id}",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteRepairsPeopleById(@PathVariable Integer id, @PathVariable Integer login_id){
        int RepairsPeopleResult = repairsPeopleService.deleteRepairsPeople(id);
        int loginResult = loginService.deleteLogin(login_id);

        if(RepairsPeopleResult == 0 || loginResult == 0){
            throw new RuntimeException();
        } else
            return true;
    }
}
