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

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private LoginService loginService;

    /**
     * 进行登录验证
     * @param map
     * @return
     */
    @RequestMapping(value = "/validation", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> validation(@RequestBody  Map map){
        Map<String,Object> modelMap = new HashMap<>();
        System.out.println("role: " + map.get("role"));
        JSONObject object = JSONObject.fromObject(map.get("Login"));
        Login token = (Login) JSONObject.toBean(object,Login.class);
        modelMap = loginService.validate(token, (int)map.get("role"));
        logger.info("登录凭证 log4j  : " + token);
        return modelMap;
    }


}
