package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Notice;
import com.jiefeng.ssm.bean.Notice;
import com.jiefeng.ssm.dao.LoginMapper;
import com.jiefeng.ssm.dao.NoticeMapper;
import com.jiefeng.ssm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Controller("NoticeService")
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private NoticeMapper NoticeMapper;

    /**
     * 获取所有的学生
     * @return
     */
    @Override
    public List<Notice> getAllNotice() {
        return NoticeMapper.selectAll();
    }

    @Override
    @Transactional
    public int updateNotice(Notice Notice) {
        System.out.println("Notice: " + Notice);
        try{
            NoticeMapper.updateByPrimaryKey(Notice);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }

        return 1;
    }

    @Override
    @Transactional
    public int insertNotice(Notice Notice) {
        int insert1 = NoticeMapper.insert(Notice);
        if(insert1 == 1){
            return 1;
        }else{
            throw new RuntimeException();
        }
    }

    @Override
    public int deleteNotice(Integer id) {
        return NoticeMapper.deleteByPrimaryKey(id);
    }
}
