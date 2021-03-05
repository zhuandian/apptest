package com.zhuandian.apptest.controller;

import com.zhuandian.apptest.pojo.AppInfoEntity;
import com.zhuandian.apptest.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.Response;

/**
 * desc:
 * author: xiedong
 * date: 2021/3/1
 **/
@RestController
public class AppInfoController {

    @Autowired
    AppInfoService appInfoService;

    @PostMapping("/insertAppInfo")
    public Response insertAppInfo(@RequestBody AppInfoEntity appInfoEntity) {
        return appInfoService.insertAppInfo(appInfoEntity);
    }

    @GetMapping("/getAllInfoList")
    public Response getAllInfoList() {
        return appInfoService.getAllInfoList();
    }

    @GetMapping("/getAllInfoListByDeviceId")
    public Response getAllInfoListByDevicesId(@RequestParam("deviceId") String deviceId) {
        return appInfoService.getAllInfoListByDeviceId(deviceId);
    }
}
