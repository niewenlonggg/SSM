package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Login;
import com.jiefeng.ssm.service.LoginService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/adminValidation",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> adminValidation(@RequestBody Map map){

        logger.info("info from front: " + map);

        Map<String,Object> modelMap = new HashMap<>();

        JSONObject object = JSONObject.fromObject(map.get("adminLogin"));
        Login token = (Login) JSONObject.toBean(object, Login.class);
        //进行验证
        modelMap = loginService.adminValidation(token);

        return modelMap;
    }

    @RequestMapping(value = "/validation",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> validation(@RequestBody Map map){

        logger.info("info from front: " + map);

        Map<String,Object> modelMap = new HashMap<>();

        JSONObject object = JSONObject.fromObject(map.get("Login"));
        Login token = (Login) JSONObject.toBean(object, Login.class);

        //获取用户的登录类型
        int role = (int) map.get("role");
        //进行验证
        modelMap = loginService.validation(role,token);

        return modelMap;
    }


    @RequestMapping(value = "/changePassword",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> changePassword(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        String oldPassword = (String) map.get("oldPassword");
        String newPassword = (String) map.get("newPassword");

        try {
            modelMap = loginService.updateAdminPassword(oldPassword,newPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return modelMap;
    }
}
