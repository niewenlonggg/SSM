package com.jiefeng.ssm.web;

import com.jiefeng.ssm.bean.RepairsTable;
import com.jiefeng.ssm.service.RepairsTableService;
import com.jiefeng.ssm.util.ValidationUpload;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/first")
public class RepairsTableController {

    Logger logger = LoggerFactory.getLogger(RepairsTableController.class);

    @Autowired
    private RepairsTableService repairsTableService;

    @RequestMapping(value = "/getFirstTable",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getFirstTable(){
        Map<String,Object> modelMap = new HashMap<>();

        List<RepairsTable> firstTableList = repairsTableService.getFirstTable();
        modelMap.put("success",true);
        modelMap.put("firstTableList",firstTableList);
        return modelMap;
    }

    @RequestMapping(value = "/getMoreTable",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getMoreTable(){
        Map<String,Object> modelMap = new HashMap<>();

        List<RepairsTable> moreTableList = repairsTableService.selectTableMore();
        modelMap.put("success",true);
        modelMap.put("moreTable",moreTableList);
        return modelMap;
    }


    /**
     * 插入图片
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/insertImage")
    @ResponseBody
    private Map<String,Object> insertImage(HttpServletRequest request) throws IOException {

        if(!ValidationUpload.status){
            repairsTableService.clearFailureUpload();
        }

        Map<String,Object> modelMap = new HashMap<>();
        String number = request.getParameter("number");
        logger.info("number: " + number);

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = multipartRequest.getFiles("tableImg");

        Map<String, Object> insertImageMap = repairsTableService.insertImage(files.get(0), number);

        RepairsTable repairsTable = new RepairsTable();
        repairsTable.setId((Integer) insertImageMap.get("repairsTableId"));
        repairsTable.setImageUrl((String)insertImageMap.get("imagePath"));
        logger.info("图片保存相对地址: " + insertImageMap.get("imagePath"));
        int result = repairsTableService.updateRepairsTable(repairsTable);
        if(result == 1){
            ValidationUpload.status = false;
            ValidationUpload.id = (Integer) insertImageMap.get("repairsTableId");
            ValidationUpload.imagePath = (String)insertImageMap.get("imagePath");
            modelMap.put("success",true);
            modelMap.put("repairsTableId",insertImageMap.get("repairsTableId"));
        }
        else
            modelMap.put("success",false);
        return modelMap;
    }

    @RequestMapping(value = "/insertRepairTable",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> insertRepairTable(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        int result = 0;

        try{
            JSONObject object = JSONObject.fromObject(map.get("repairTable"));
            logger.info("JSONObject: " + object);
            RepairsTable repairsTable = new RepairsTable();
            repairsTable.setId(ValidationUpload.id);
            repairsTable.setRepairDesc((String)object.get("desc"));
            repairsTable.setRepairAddress((String)object.get("address"));
            repairsTable.setCreateTime(new Date());
            repairsTable.setStatus(0);
            result = repairsTableService.updateRepairsTable(repairsTable);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result == 1)
            modelMap.put("success",true);
        else
            modelMap.put("success",false);
        return modelMap;
    }


    @RequestMapping(value = "/receiveTheRepair",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> receiveTheRepair(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();

        //获取前端传过来的订单id 和 接单人员编号
        Integer id = (Integer) map.get("id");
        String number = (String) map.get("number");

        //打印信息
        logger.info("number: " + number + " id: " + id);

        //更新未接单的信息
        RepairsTable repairsTable = new RepairsTable();
        repairsTable.setId(id);
        repairsTable.setRepairNumber(number);
        repairsTable.setStatus(1);

        //检查是否更新成功
        int i = repairsTableService.updateRepairsTable(repairsTable);
        if(i <= 0)
            modelMap.put("success",false);
        else
            modelMap.put("success",true);

        return  modelMap;
    }


    @RequestMapping(value = "/getHistoryOrRepairing",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> getHistoryOrRepairing(@RequestBody Map map){

        Map<String,Object> modelMap = new HashMap<>();

        List<RepairsTable> repairsTableList = new ArrayList<>();

        //获取History还是Repairing
        String type = (String) map.get("type");

        //获取角色类型
        String role = (String) map.get("role");

        //获取编号
        String number = (String) map.get("number");

        //如果是获取历史订单
        if(type.equals("history")){
            logger.info("in history");
            RepairsTable repairsTable = new RepairsTable();
            //判断角色类型
            if(role.equals("3")){
                //如果是维修人员
                repairsTable.setRepairNumber(number);
                repairsTableList = repairsTableService.selectHistory(repairsTable);
            }else{
                //普通人员
                repairsTable.setSubmitNumber(number);
                repairsTableList = repairsTableService.selectHistory(repairsTable);
            }
        }else{
            //获取正在维修的订单
            RepairsTable repairsTable1 = new RepairsTable();
            //判断角色类型
            if(role.equals("3")){
                //如果是维修人员
                repairsTable1.setRepairNumber(number);
                repairsTableList = repairsTableService.selectRepairing(repairsTable1);
            }else{
                //普通人员
                repairsTable1.setSubmitNumber(number);
                repairsTableList = repairsTableService.selectRepairing(repairsTable1);
            }

        }

        logger.info(repairsTableList.toString());
        if(repairsTableList != null){
            modelMap.put("success",true);
            modelMap.put("tableList",repairsTableList);
        }else{
            modelMap.put("success",false);
        }

        return modelMap;
    }


    /**
     * 打评论
     * @param map
     * @return
     */
    @RequestMapping(value = "/updateAssessment",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> updateAssessment(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        //获取Table的id
        Integer id = (Integer) map.get("id");

        //获取评论值
        Integer assessment = (Integer) map.get("assessment");

        RepairsTable repairsTable = new RepairsTable();
        repairsTable.setId(id);
        repairsTable.setAssessment(assessment);

        int i = repairsTableService.updateRepairsTable(repairsTable);
        if(i <= 0)
            modelMap.put("success",false);
        else
            modelMap.put("success",true);
        return modelMap;
    }


    @RequestMapping(value = "/changeFinished",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> changeFinished(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        //获取Table的id
        Integer id = (Integer) map.get("id");
        RepairsTable repairsTable = new RepairsTable();
        repairsTable.setId(id);
        repairsTable.setStatus(4);
        int i = repairsTableService.updateRepairsTable(repairsTable);
        if(i <= 0)
            modelMap.put("success",false);
        else
            modelMap.put("success",true);
        return modelMap;
    }

}
