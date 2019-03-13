package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Manager;
import com.jiefeng.ssm.dao.LoginMapper;
import com.jiefeng.ssm.dao.ManagerMapper;
import com.jiefeng.ssm.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ManagerService")
public class ManagerServiceImpl implements ManagerService {


    @Autowired
    private ManagerMapper managerMapper;


    @Autowired
    private LoginMapper loginMapper;
    /**
     * 获取所有的学生
     * @return
     */
    @Override
    public List<Manager> getAllManager() {
        return managerMapper.selectAll();
    }

    @Override
    @Transactional
    public int updateManager(Manager Manager) {
        try{
            managerMapper.updateByPrimaryKey(Manager);
            if(Manager.getLogin() != null)
                loginMapper.updateByPrimaryKey(Manager.getLogin());
        }catch (Exception e){
            throw new RuntimeException();
        }

        return 1;
    }

    @Override
    @Transactional
    public int insertManager(Manager Manager) {

        int insert = loginMapper.insert(Manager.getLogin());
        if(insert == 1){
            int insert1 = managerMapper.insert(Manager);
            if(insert1 == 1){
                return 1;
            }else{
                throw new RuntimeException();
            }
        }
        return 0;
    }

    @Override
    public int deleteManager(Integer id) {
        return managerMapper.deleteByPrimaryKey(id);
    }
}
