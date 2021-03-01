package com.zhuandian.apptest;

import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuandian.apptest.base.BaseActivity;
import com.zhuandian.apptest.utils.AppUtils;
import com.zhuandian.apptest.utils.SystemUtil;
import com.zhuandian.apptest.utils.TimeUtils;
import com.zhuandian.network.CallBack;
import com.zhuandian.network.HttpEntity;
import com.zhuandian.network.HttpManager;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import io.reactivex.Observable;


public class MainActivity extends BaseActivity {

    private TextView tvInfo;
    Timer timer = new Timer();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setUpView() {
        tvInfo = findViewById(R.id.tv_info);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("APP信息：")
                        .append("\n")
                        .append("应用程序名称：" + AppUtils.getAppName(MainActivity.this))
                        .append("\n")
                        .append("应用的版本名称：" + AppUtils.getVersionName(MainActivity.this))
                        .append("\n")
                        .append("应用的版本号：" + AppUtils.getVersionCode(MainActivity.this))
                        .append("\n")
                        .append("应用程序包名：" + AppUtils.getPackageName(MainActivity.this))
                        .append("\n")
                        .append("内存占用率：" + AppUtils.getUsedPercentValue(MainActivity.this))
                        .append("\n")
                        .append("\n")
                        .append("系统参数：")
                        .append("\n")
                        .append("手机厂商：" + SystemUtil.getDeviceBrand())
                        .append("\n")
                        .append("手机型号：" + SystemUtil.getSystemModel())
                        .append("\n")
                        .append("手机当前系统语言：" + SystemUtil.getSystemLanguage())
                        .append("\n")
                        .append("Android系统版本号：" + SystemUtil.getSystemVersion())
                        .append("\n")
                        .append("CPU型号：" + SystemUtil.getCPUType())
                        .append("\n")
                        .append("磁盘信息：" + SystemUtil.getDevSpace())
                        .append("\n")
                        .append("设备ID：" + SystemUtil.DeviceId(MainActivity.this))
                        .append("\n")
                        .append("网速：" + SystemUtil.getNetSpeed());

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvInfo.setText(stringBuilder.toString());
                    }
                });

                uploadData();
            }
        }, 1000, 1000 * 60);

        showSystemParameter();

        getAppInfo();
    }



    private void uploadData() {
        Entity entity = new Entity();
        entity.setAppName(AppUtils.getAppName(this));
        entity.setVersionName(AppUtils.getVersionName(this));
        entity.setVersionCode(AppUtils.getVersionCode(this)+"");
        entity.setPackageName(AppUtils.getPackageName(this));
        entity.setUsedPercentValue(AppUtils.getUsedPercentValue(this));

        entity.setDeviceBrand(SystemUtil.getDeviceBrand());
        entity.setSystemModel(SystemUtil.getSystemModel());
        entity.setSystemLanguage(SystemUtil.getSystemLanguage());
        entity.setSystemVersion(SystemUtil.getSystemVersion());
        entity.setCpuType(SystemUtil.getCPUType());
        entity.setDevSpace(SystemUtil.getDevSpace());
        entity.setDeviceId(SystemUtil.DeviceId(this));
        entity.setNetSpeed(SystemUtil.getNetSpeed());
        entity.setCreateAt(TimeUtils.getTimeStrNow());
        entity.setUpdateAt(TimeUtils.getTimeStrNow());

        Observable<HttpEntity<String>> observable = getApi().insertAppInfo(entity);
        HttpManager.getInstance().doHttpRequest(activity, observable, new CallBack<String>() {
            @Override
            public void onSuccess(String result) {
                if ("success".equals(result)){
                    Toast.makeText(MainActivity.this, "数据更新成功...", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onError(Exception e) {
                String message = e.getMessage();
            }
        });
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