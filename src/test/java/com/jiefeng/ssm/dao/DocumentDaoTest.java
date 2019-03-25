package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Document;
import com.jiefeng.ssm.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class DocumentDaoTest extends BaseTest {

    @Autowired
    private DocumentDao documentDao;

    @Test
    public void testGetAllDocument(){
//        List<Document> allDocument = documentDao.getAllDocument();
//        for (Document document : allDocument) {
//            System.out.println(document);
//        }
        boolean b = documentDao.updateDocumentDate(1, new Date());
        System.out.println(b);
    }

    @Test
    public void testInsertDocument(){
        Document document = new Document();

        document.setUrl("girl.jpg");
        User user = new User();
        user.setId(4);
        document.setStudentId(user);

        com.jiefeng.ssm.bean.Test testId = new com.jiefeng.ssm.bean.Test();
        testId.setId(3);

        document.setTestId(testId);

        document.setCreateTime(new Date());

        boolean b = documentDao.insertDocument(document);
        System.out.println(b);



    }
}
