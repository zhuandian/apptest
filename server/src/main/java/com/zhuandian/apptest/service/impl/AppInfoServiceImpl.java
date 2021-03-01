package com.zhuandian.apptest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhuandian.apptest.mapper.AppInfoMapper;
import com.zhuandian.apptest.pojo.AppInfoEntity;
import com.zhuandian.apptest.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
@Service
public class AppInfoServiceImpl extends ServiceImpl<AppInfoMapper, AppInfoEntity> implements AppInfoService {
    @Autowired
    AppInfoMapper appInfoMapper;

    @Override
    public Response insertAppInfo(AppInfoEntity appInfoEntity) {
        int insert = appInfoMapper.insert(appInfoEntity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", insert == 1 ? "success" : "error");
        return Response.ok(map);
    }

    @Override
    public Response getAllInfoList() {
        List<AppInfoEntity> appInfoEntityList = appInfoMapper.selectList(null);
        Map<String, Object> map = new HashMap<>();
        map.put("data", appInfoEntityList);
        return Response.ok(map);
    }
}
