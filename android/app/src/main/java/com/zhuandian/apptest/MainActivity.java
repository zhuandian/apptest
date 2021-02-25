package com.zhuandian.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.zhuandian.apptest.utils.AppUtils;
import com.zhuandian.apptest.utils.SystemUtil;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showSystemParameter();

        getAppInfo();
    }

    private void getAppInfo() {
        String TAG = "APP信息：";
        Log.e(TAG, "应用程序名称：" + AppUtils.getAppName(this));
        Log.e(TAG, "应用的版本名称：" + AppUtils.getVersionName(this));
        Log.e(TAG, "应用的版本号：" + AppUtils.getVersionCode(this));
        Log.e(TAG, "应用程序包名：" + AppUtils.getPackageName(this));
        Log.e(TAG, "内存占用率：" + AppUtils.getUsedPercentValue(this));

    }

    private void showSystemParameter() {
        String TAG = "系统参数：";
        Log.e(TAG, "手机厂商：" + SystemUtil.getDeviceBrand());
        Log.e(TAG, "手机型号：" + SystemUtil.getSystemModel());
        Log.e(TAG, "手机当前系统语言：" + SystemUtil.getSystemLanguage());
        Log.e(TAG, "Android系统版本号：" + SystemUtil.getSystemVersion());
        Log.e(TAG, "CPU型号：" + SystemUtil.getCPUType());
        Log.e(TAG, "磁盘信息：" + SystemUtil.getDevSpace());
        Log.e(TAG, "设备ID：" + SystemUtil.DeviceId(this));
        Log.e(TAG, "网速：" + SystemUtil.getNetSpeed());
//        Log.e(TAG, "CPU使用率：" + Long.parseLong(CPUUtil.getCurCpuFreq())/Long.parseLong(CPUUtil.getMaxCpuFreq()));

    }


}