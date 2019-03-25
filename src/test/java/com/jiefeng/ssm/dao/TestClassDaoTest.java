package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestClassDaoTest extends BaseTest {

    @Autowired
    private TestClassDao testClassDao;

    @Test
    public void testBatchInsert(){
        Integer testId = 5;
        List<Integer> permissionList = new ArrayList<>();
        permissionList.addAll(Arrays.asList(1,3,4));


        boolean b = testClassDao.batchInsert(testId, permissionList);
        System.out.println(b);
    }
}
