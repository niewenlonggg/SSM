package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Document;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

public interface DocumentService {

    /**
     * 获取所有的具体上传实验
     * @return
     */
    List<Document>  getAllDocument();


    String insertDocument(HttpServletRequest request) throws IOException;

}
