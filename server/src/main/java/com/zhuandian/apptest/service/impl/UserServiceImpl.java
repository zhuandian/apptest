package com.zhuandian.apptest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuandian.apptest.mapper.UserMapper;
import com.zhuandian.apptest.pojo.UserEntity;
import com.zhuandian.apptest.service.UserService;
import org.springframework.stereotype.Service;



/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {

}
