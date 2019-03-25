package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.BaseTest;
import com.jiefeng.ssm.bean.Comment;
import com.jiefeng.ssm.bean.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class CommentDaoTest extends BaseTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void testInsertComment(){
        Comment comment = new Comment();
        User user = new User();
        user.setId(2);
        comment.setAcceptId(user);

        com.jiefeng.ssm.bean.Test test = new com.jiefeng.ssm.bean.Test();

        test.setId(1);

        comment.setTestId(test);

        comment.setContent("你的做的实验非常不好");

        comment.setCreateTime(new Date());

        boolean b = commentDao.insertComment(comment);
        System.out.println(b);

    }


    @Test
    public void testGetAllTest(){
        List<Comment> commentsByStudentId = commentDao.getCommentsByStudentId(2);
        for (Comment comment : commentsByStudentId) {
            System.out.println(comment);
        }
    }
}
