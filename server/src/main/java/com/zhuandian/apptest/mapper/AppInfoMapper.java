package com.zhuandian.apptest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhuandian.apptest.pojo.AppInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
@Repository
@Mapper
public interface AppInfoMapper extends BaseMapper<AppInfoEntity> {
}
