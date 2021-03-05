package com.zhuandian.apptest.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhuandian.apptest.pojo.AppInfoEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
public interface AppInfoService extends IService<AppInfoEntity> {
    Response insertAppInfo(AppInfoEntity appInfoEntity);

    Response getAllInfoList();

    Response getAllInfoListByDeviceId( String deviceId);
}
