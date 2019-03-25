package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 验证用户的登录信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/validation",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> validation(@RequestBody Map map){

        //从前端穿过来的数据中取出用户登录凭证
        JSONObject userInfo = JSONObject.fromObject(map.get("userInfo"));

        //将登录凭证转化为User Bean
        User token = (User) JSONObject.toBean(userInfo, User.class);

        //进行验证，并且将验证后的信息传出
        Map<String,Object> modelMap = userService.validation(token);

        return  modelMap;
    }

    /**
     * 验证用户的登录信息
     * @param map
     * @return
     */
    @RequestMapping(value = "/adminValidation",method = RequestMethod.POST)
    @ResponseBody
    public boolean adminValidation(@RequestBody Map map){

        JSONObject object = JSONObject.fromObject(map.get("adminLoginToken"));
        User user = (User)JSONObject.toBean(object,User.class);

        boolean b = userService.adminValidation(user);
        return  b;
    }
}
