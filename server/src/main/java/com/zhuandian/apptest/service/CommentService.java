package com.zhuandian.apptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuandian.apptest.pojo.CommentEntity;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/3
 **/
public interface CommentService extends IService<CommentEntity> {

    Response getCommentListByAppInfoId(long appInfoId);

    Response addNewComment(CommentEntity commentEntity);

}
