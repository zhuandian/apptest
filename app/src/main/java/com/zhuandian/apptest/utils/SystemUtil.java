package com.zhuandian.apptest.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;

import java.util.Locale;

public class SystemUtil {

    /**
     * 获取当前手机系统语言。
     *
     * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
     */
    public static String getSystemLanguage() {
        return Locale.getDefault().getLanguage();
    }

    /**
     * 获取当前系统上的语言列表(Locale列表)
     *
     * @return 语言列表
     */
    public static Locale[] getSystemLanguageList() {
        return Locale.getAvailableLocales();
    }

    /**
     * 获取当前手机系统版本号
     *
     * @return 系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return 手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }

    /**
     * 获取手机厂商
     *
     * @return 手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }



    public static String getCPUType() {
        return android.os.Build.CPU_ABI;
    }

    public static String getDevSpace() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {        //判断sdcard 是否可以用
            StatFs sf = new StatFs(Environment.getDataDirectory().getPath());      //sdcard 类 空间信息
            long blockSize = sf.getBlockSize();        //    一个block大小
            long blockCount = sf.getBlockCount();      //    总block 数
            long availCount = sf.getAvailableBlocks();  //    剩余block 数
            long M = 1048576;                          // 字节转MB
            long G = 1073741824;
            long totalSize = blockSize * blockCount / G;      // 总空间
            long surplus = availCount * blockSize / G;          //    剩余空间
            return "设备总空间：" + totalSize + "GB " + " 剩余空间：" + surplus + "GB";
        }
        return "";

    }
}
