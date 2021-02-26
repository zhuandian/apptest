package com.zhuandian.apptest.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * desc:
 * author: xiedong
 * date: 2/25/21
 **/
@Data
@TableName("app_info")
public class AppInfoEntity {
    private long id;
    private String appName;
    private String versionName;
    private String versionCode;
    private String packageName;
    private String usedPercentValue;
    private String deviceBrand;
    private String systemModel;
    private String systemLanguage;
    private String systemVersion;
    private String cpuType;
    private String devSpace;
    private String deviceId;
    private String netSpeed;
}
