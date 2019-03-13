package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Notice;
import com.jiefeng.ssm.service.NoticeService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping(value = "/getAllNotice",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllNotice(){
        Map<String,Object> modelMap = new HashMap<>();

        List<Notice> NoticeList = noticeService.getAllNotice();

        if(NoticeList != null){
            modelMap.put("success",true);
            modelMap.put("NoticeList",NoticeList);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }

    @RequestMapping(value = "/insertOrEditNotice",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> insertOrEditNotice(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        int result = 0;

        try{
            // 0 添加  1 编辑
            Integer formType = (Integer) map.get("formType");

            JSONObject object = JSONObject.fromObject(map.get("NoticeInfo"));
            Notice Notice = (Notice) JSONObject.toBean(object, Notice.class);

            //添加操作
            if(formType == 0){
                Notice.setCreateTime(new Date());
                result = noticeService.insertNotice(Notice);
            }else{
                //更新操作
                result = noticeService.updateNotice(Notice);
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


    @RequestMapping(value = "/deleteNoticeById/{id}",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteNoticeById(@PathVariable Integer id){
        int NoticeResult = noticeService.deleteNotice(id);

        if(NoticeResult == 0){
            throw new RuntimeException();
        } else
            return true;
    }
}
