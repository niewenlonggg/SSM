package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.RepairsPeople;
import com.jiefeng.ssm.dao.LoginMapper;
import com.jiefeng.ssm.dao.RepairsPeopleMapper;
import com.jiefeng.ssm.service.RepairsPeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RepairPeopleService")
public class RepairPeopleServiceImpl implements RepairsPeopleService {

    @Autowired
    private RepairsPeopleMapper repairsPeopleMapper;


    @Autowired
    private LoginMapper loginMapper;
    /**
     * 获取所有的学生
     * @return
     */
    @Override
    public List<RepairsPeople> getAllRepairsPeople() {
        return repairsPeopleMapper.selectAll();
    }

    @Override
    @Transactional
    public int updateRepairsPeople(RepairsPeople RepairsPeople) {
        try{
            repairsPeopleMapper.updateByPrimaryKey(RepairsPeople);
            if(RepairsPeople.getLogin() != null)
                loginMapper.updateByPrimaryKey(RepairsPeople.getLogin());
        }catch (Exception e){
            throw new RuntimeException();
        }

        return 1;
    }

    @Override
    @Transactional
    public int insertRepairsPeople(RepairsPeople RepairsPeople) {

        int insert = loginMapper.insert(RepairsPeople.getLogin());
        if(insert == 1){
            int insert1 = repairsPeopleMapper.insert(RepairsPeople);
            if(insert1 == 1){
                return 1;
            }else{
                throw new RuntimeException();
            }
        }
        return 0;
    }

    @Override
    public int deleteRepairsPeople(Integer id) {
        return repairsPeopleMapper.deleteByPrimaryKey(id);
    }
}
