package com.jiefeng.ssm.web;


import com.jiefeng.ssm.bean.Comment;
import com.jiefeng.ssm.bean.Test;
import com.jiefeng.ssm.bean.User;
import com.jiefeng.ssm.service.CommentService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/getAllCommentByStudentId/{id}",method = RequestMethod.GET)
    @ResponseBody
    private List<Comment> getAllCommentByStudentId(@PathVariable Integer id){
        return commentService.getAllComment(id);
    }

    @RequestMapping(value = "/deleteCommentByPrimaryId/{id}",method = RequestMethod.GET)
    @ResponseBody
    private boolean deleteCommentByPrimaryId(@PathVariable Integer id){
        return commentService.deleteComment(id);
    }

    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    @ResponseBody
    private boolean insertComment(@RequestBody Map map){

        System.out.println(map);

        Comment comment = new Comment();

        JSONObject object = JSONObject.fromObject(map.get("comment"));

        Integer acceptId = (Integer) object.get("acceptId");
        User user = new User();
        user.setId(acceptId);
        comment.setAcceptId(user);

        Integer testId = (Integer) object.get("testId");
        Test test = new Test();
        test.setId(testId);
        comment.setTestId(test);


        String content = (String) object.get("content");
        comment.setCreateTime(new Date());
        comment.setContent(content);

        boolean b = commentService.insertComment(comment);
        if(b)
            return true;

        return false;
    }

    @RequestMapping(value = "/getAllComment",method = RequestMethod.GET)
    @ResponseBody
    private List<Comment> getAllComment(){
        return commentService.getAllCommentAdmin();
    }

}
