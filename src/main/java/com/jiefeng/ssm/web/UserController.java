package com.jiefeng.ssm.web;


import com.jiefeng.ssm.bean.TbClass;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户信息
     * @param type
     * @return
     */
    @RequestMapping("/getUser/{type}")
    @ResponseBody
    public List<User> getUserByType(@PathVariable Integer type){
        return userService.getUserInfoByType(type);
    }


    /**
     * 删除用户信息
     * @param id
     * @return
     */
    @RequestMapping("/deleteUserByPrimaryKey/{id}")
    @ResponseBody
    public List<User> deleteUserByPrimaryKey(@PathVariable Integer id){
        return userService.getUserInfoByType(id);
    }



    @RequestMapping(value = "/addOrEditUser",method = RequestMethod.POST)
    @ResponseBody
    public boolean addOrEditUser(@RequestBody Map map){

        boolean b = false;

        System.out.println(map);

        try{
            JSONObject object = JSONObject.fromObject(map.get("user"));
            User user = (User) JSONObject.toBean(object, User.class);
            if(user.getType() == 0){
                Integer classId = (Integer) map.get("classId");
                TbClass tbClass = new TbClass();
                tbClass.setId(classId);
                user.setClassId(tbClass);
            }
            if((boolean)map.get("addOrEdit")){
                b = userService.insertUser(user);
            }else{
                b = userService.updateUser(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return b;
    }

}
