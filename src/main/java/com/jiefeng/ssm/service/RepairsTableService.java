package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.RepairsTable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface RepairsTableService {

    /**
     * 获取公告上最新的维修信息
     * @return
     */
    List<RepairsTable> getFirstTable();

    List<RepairsTable> selectTableMore();

    List<RepairsTable> selectHistory(RepairsTable repairsTable);

    List<RepairsTable> selectRepairing(RepairsTable repairsTable);
    Map<String,Object> insertImage(MultipartFile file, String number);

    int updateRepairsTable(RepairsTable repairsTable);


    int deleteRepairsTable(Integer id);

    void clearFailureUpload();

}
