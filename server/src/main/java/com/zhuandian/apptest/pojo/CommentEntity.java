package com.zhuandian.apptest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/3
 **/
@Data
@TableName("comment")
public class CommentEntity {
    private long id;
    private long userId;
    private long appInfoId;
    private String userName;
    private String comment;
    private String createAt;
    private String updateAt;
}
