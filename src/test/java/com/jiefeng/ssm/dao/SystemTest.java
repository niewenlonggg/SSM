package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import org.junit.Test;

public class SystemTest extends BaseTest {

    @Test
    public void testSystem(){
        System.out.println(System.getProperty("os.name"));
    }

}
