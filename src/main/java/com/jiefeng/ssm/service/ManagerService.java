package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Manager;

import java.util.List;

public interface ManagerService {

    List<Manager> getAllManager();

    int updateManager(Manager Manager);

    int insertManager(Manager Manager);

    int deleteManager(Integer id);
}
