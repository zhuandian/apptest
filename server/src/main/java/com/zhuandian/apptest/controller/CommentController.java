package com.zhuandian.apptest.controller;

import com.zhuandian.apptest.pojo.CommentEntity;
import com.zhuandian.apptest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/3
 **/
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/getCommentListByAppInfoId")
    public Response getCommentListByAppInfoId(@RequestParam("appInfoId") long appInfoId){
        return commentService.getCommentListByAppInfoId(appInfoId);
    }

    @PostMapping("/addNewComment")
    public Response addNewComment(@RequestBody CommentEntity commentEntity){
        return commentService.addNewComment(commentEntity);
    }
}
