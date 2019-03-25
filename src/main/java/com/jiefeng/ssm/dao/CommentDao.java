package com.jiefeng.ssm.dao;

import com.jiefeng.ssm.bean.Comment;

import java.util.List;

public interface CommentDao {

    boolean insertComment(Comment comment);

    List<Comment> getCommentsByStudentId(Integer studentId);

    boolean deleteCommentByPrimaryId(Integer id);

    List<Comment> getAllComment();

}
