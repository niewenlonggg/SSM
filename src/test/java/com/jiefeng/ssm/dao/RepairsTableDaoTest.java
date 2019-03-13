package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.RepairsTable;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class RepairsTableDaoTest extends BaseTest {

    @Autowired
    private RepairsTableMapper repairsTableMapper;

    @Test
    public void testAddTable(){
//            RepairsTable repairsTable = new RepairsTable();
//            repairsTable.setRepairAddress("4号楼112");
//            repairsTable.setRepairDesc("魏鹏也被爆菊了");
//            repairsTable.setStatus(0);
//            repairsTable.setSubmitNumber("15407321");
//            repairsTable.setCreateTime(new Date());
//            repairsTableMapper.insert(repairsTable);

//        RepairsTable repairsTable = new RepairsTable();
//        repairsTable.setSubmitNumber("15407321");
//        List<RepairsTable> repairsTables = repairsTableMapper.selectHistory(repairsTable);
//        for (RepairsTable table : repairsTables) {
//            System.out.println(table);
//
//        }

        RepairsTable repairsTable = new RepairsTable();
        repairsTable.setRepairNumber("15407332");
        List<RepairsTable> repairsTables = repairsTableMapper.selectRepairing(repairsTable);
        for (RepairsTable table : repairsTables) {
            System.out.println(table);

        }

    }
}