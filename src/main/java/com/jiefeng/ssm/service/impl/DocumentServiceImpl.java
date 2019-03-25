package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Document;
import com.jiefeng.ssm.bean.Test;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.dao.DocumentDao;
import com.jiefeng.ssm.service.DocumentService;
import com.jiefeng.ssm.util.ImageUtil;
import com.jiefeng.ssm.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@Service("DocumentService")
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentDao documentDao;

    @Override
    public List<Document> getAllDocument() {
        return documentDao.getAllDocument();
    }

    @Override
    @Transactional
    public String insertDocument(HttpServletRequest request) {

        try{
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            List<MultipartFile> files = multipartRequest.getFiles("tableImg");
            Integer studentId = Integer.parseInt(request.getParameter("studentId"));
            Integer testId = Integer.parseInt(request.getParameter("testId"));

            Document documentRecord = documentDao.getDocumentByStudentIdAndTestId(studentId, testId);

            String ImageUrl = PathUtil.getDocumentImageUrl(testId);
            String url = ImageUtil.generateNormalImg(files.get(0), ImageUrl);

            if(documentRecord != null){
                ImageUtil.deleteFileOrPath(documentRecord.getUrl());
                documentRecord.setUrl(url);
                boolean b = documentDao.updateDocumentUrl(documentRecord);
                if(b)
                    return url;
            }

            Document document = new Document();

            //创建学生
            User user = new User();
            user.setId(studentId);

            //创建实验
            Test test = new Test();
            test.setId(testId);

            document.setUrl(url);

            document.setCreateTime(new Date());

            boolean b = documentDao.insertDocument(document);
            if (b)
                return url;

        }catch (Exception e){
            throw new RuntimeException();
        }
        return "";
    }


}
