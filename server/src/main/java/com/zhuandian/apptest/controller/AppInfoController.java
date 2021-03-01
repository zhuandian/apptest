package com.zhuandian.apptest.controller;

import com.zhuandian.apptest.pojo.AppInfoEntity;
import com.zhuandian.apptest.service.AppInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    public Response insertAppInfo(@RequestBody AppInfoEntity appInfoEntity){
        return appInfoService.insertAppInfo(appInfoEntity);
    }

    @GetMapping("/getAllInfoList")
    public Response getAllInfoList(){
        return appInfoService.getAllInfoList();
    }
}
