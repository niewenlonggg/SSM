package com.jiefeng.ssm.service.impl;

import com.jiefeng.ssm.bean.Comment;
import com.jiefeng.ssm.dao.CommentDao;
import com.jiefeng.ssm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {


    @Autowired
    private CommentDao commentDao;


    @Override
    public boolean insertComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public List<Comment> getAllComment(Integer studentId) {
        return commentDao.getCommentsByStudentId(studentId);
    }

    @Override
    public boolean deleteComment(Integer id) {
        return commentDao.deleteCommentByPrimaryId(id);
    }

    @Override
    public List<Comment> getAllCommentAdmin() {
        return commentDao.getAllComment();
    }


}
