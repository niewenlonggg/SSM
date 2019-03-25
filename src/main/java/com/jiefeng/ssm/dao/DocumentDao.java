package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Document;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface DocumentDao {

    List<Document> getAllDocument();

    boolean updateDocumentDate(@Param("id") Integer id, @Param("date") Date date);

    /**
     * 插入学生文档
     * @param document
     * @return
     */
    boolean insertDocument(Document document);

    /**
     *
     * @param studentId
     * @param testId
     * @return
     */
    Document getDocumentByStudentIdAndTestId(@Param("studentId") Integer studentId, @Param("testId") Integer testId);

    boolean updateDocumentUrl(Document document);
}
