package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> getAllNotice();

    int updateNotice(Notice notice);

    int insertNotice(Notice notice);

    int deleteNotice(Integer id);
}
