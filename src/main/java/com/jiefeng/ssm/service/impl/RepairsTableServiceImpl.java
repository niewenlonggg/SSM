package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.RepairsTable;
import com.jiefeng.ssm.dao.RepairsTableMapper;
import com.jiefeng.ssm.service.RepairsTableService;
import com.jiefeng.ssm.util.ImageUtil;
import com.jiefeng.ssm.util.PathUtil;
import com.jiefeng.ssm.util.ValidationUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("RepairsTableService")
public class RepairsTableServiceImpl implements RepairsTableService {

    @Autowired
    private RepairsTableMapper repairsTableMapper;

    /**
     * 获取首页左心维修信息
     * @return
     */
    @Override
    public List<RepairsTable> getFirstTable() {
        return repairsTableMapper.getFirstTable();
    }

    @Override
    public List<RepairsTable> selectTableMore() {
        return repairsTableMapper.selectTableMore();
    }

    @Override
    public List<RepairsTable> selectHistory(RepairsTable repairsTable) {
        return repairsTableMapper.selectHistory(repairsTable);
    }

    @Override
    public List<RepairsTable> selectRepairing(RepairsTable repairsTable) {
        return  repairsTableMapper.selectRepairing(repairsTable);
    }

    /**
     * 插入图片
     * @param file
     * @param number
     * @return
     */
    @Override
    @Transactional
    public Map<String,Object> insertImage(MultipartFile file, String number) {
        Map<String,Object> modelMap = new HashMap<>();

        try{
            RepairsTable repairsTable = new RepairsTable();
            repairsTable.setSubmitNumber(number);
            repairsTableMapper.insert(repairsTable);
            String rootAddr = PathUtil.getImagePath(number);
            String imagePath = ImageUtil.generateNormalImg(file,rootAddr);
            modelMap.put("repairsTableId",repairsTable.getId());
            System.out.println(repairsTable.getId());
            modelMap.put("imagePath",imagePath);
        }catch (Exception e){
            throw new RuntimeException();
        }

        return modelMap;
    }

    /**
     * 更新repairsTable信息
     * @param repairsTable
     * @return
     */
    @Override
    public int updateRepairsTable(RepairsTable repairsTable) {
        return repairsTableMapper.updateByPrimaryKey(repairsTable);
    }

    @Override
    public int deleteRepairsTable(Integer id) {
        return repairsTableMapper.deleteByPrimaryKey(id);
    }

    /**
     * 清理没有上传完整的repairTable
     */
    @Override
    @Transactional
    public void clearFailureUpload(){
        try {
            repairsTableMapper.deleteByPrimaryKey(ValidationUpload.id);
            ImageUtil.deleteFileOrPath(ValidationUpload.imagePath);
        }catch (Exception e){
            throw new RuntimeException("ClearFailureUpload");
        }

    }

}
