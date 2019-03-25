package com.jiefeng.ssm.service;

import com.jiefeng.ssm.bean.Comment;

import java.util.List;

public interface CommentService {

    boolean insertComment(Comment comment);


    List<Comment> getAllComment(Integer studentId);


    boolean deleteComment(Integer id);

    List<Comment> getAllCommentAdmin();
}
