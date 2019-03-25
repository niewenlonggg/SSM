package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.Document;
import com.jiefeng.ssm.bean.Test;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;


    @RequestMapping(value = "/getAllDocument")
    @ResponseBody
    public List<Document> getAllDocument(){
        return documentService.getAllDocument();
    }


    @RequestMapping(value = "/insertDocument",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertDocument(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();

        try{
            String s = documentService.insertDocument(request);
            if(!"".equals(s))
                 modelMap.put("success",true);
            else
                modelMap.put("success",false);
        }catch (Exception e){
            e.printStackTrace();
        }

        return modelMap;
    }
}
