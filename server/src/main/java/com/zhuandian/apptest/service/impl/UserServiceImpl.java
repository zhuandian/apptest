package com.zhuandian.apptest.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuandian.apptest.pojo.UserEntity;
import com.zhuandian.apptest.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.function.Function;

/**
 * desc:
 * author: xiedong
 * date: 2021/2/26
 **/
@Service
public class UserServiceImpl implements UserService {
    @Override
    public boolean saveBatch(Collection<UserEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdateBatch(Collection<UserEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean updateBatchById(Collection<UserEntity> entityList, int batchSize) {
        return false;
    }

    @Override
    public boolean saveOrUpdate(UserEntity entity) {
        return false;
    }

    @Override
    public UserEntity getOne(Wrapper<UserEntity> queryWrapper, boolean throwEx) {
        return null;
    }


    @Override
    public Map<String, Object> getMap(Wrapper<UserEntity> queryWrapper) {
        return null;
    }

    @Override
    public <V> V getObj(Wrapper<UserEntity> queryWrapper, Function<? super Object, V> mapper) {
        return null;
    }

    @Override
    public BaseMapper<UserEntity> getBaseMapper() {
        return null;
    }
}
