package com.zhuandian.apptest.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuandian.apptest.mapper.CommentMapper;
import com.zhuandian.apptest.pojo.CommentEntity;
import com.zhuandian.apptest.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/3
 **/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements CommentService {

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Response getCommentListByAppInfoId(long appInfoId) {
        List<CommentEntity> commentEntityList = commentMapper.selectList(new QueryWrapper<CommentEntity>()
                .eq("appInfoId", appInfoId)
        );
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "success");
        map.put("data", commentEntityList);
        return Response.ok(map);
    }

    @Override
    public Response addNewComment(CommentEntity commentEntity) {
        int insert = commentMapper.insert(commentEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", insert == 1 ? "success" : "error");
        return Response.ok(map);
    }
}
