package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.RepairsPeople;

import java.util.List;

public interface RepairsPeopleService {
    
    List<RepairsPeople> getAllRepairsPeople();

    int updateRepairsPeople(RepairsPeople RepairsPeople);

    int insertRepairsPeople(RepairsPeople RepairsPeople);

    int deleteRepairsPeople(Integer id);
}
