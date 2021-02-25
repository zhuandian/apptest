package com.zhuandian.apptest.utils;

import android.app.Activity;
import android.content.Context;
import android.net.TrafficStats;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.content.Context.TELEPHONY_SERVICE;

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


    public static String DeviceId(Context context) {
        return Settings.System.getString(
                context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }


    private static long lastTotalRxBytes = 0;
    private static long lastTimeStamp = 0;

    public static String getNetSpeed() {
        long nowTotalRxBytes = getTotalRxBytes();
        long nowTimeStamp = System.currentTimeMillis();
        long speed = ((nowTotalRxBytes - lastTotalRxBytes) * 1000 / (nowTimeStamp - lastTimeStamp));//毫秒转换
        lastTimeStamp = nowTimeStamp;
        lastTotalRxBytes = nowTotalRxBytes;
        return String.valueOf(speed) + " kb/s";
    }


    public static long getTotalRxBytes() {
        return TrafficStats.getTotalRxBytes() == TrafficStats.UNSUPPORTED ? 0 : (TrafficStats.getTotalRxBytes() / 1024);//转为KB
    }






    /**
     * 获取cpu使用率
     * @return
     */
    public static float getCpuUsed() {
        try {
            RandomAccessFile reader = new RandomAccessFile("/proc/stat", "r");
            String load = reader.readLine();
            String[] toks = load.split(" ");
            long idle1 = Long.parseLong(toks[5]);
            long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);
            try {
                Thread.sleep(360);
            } catch (Exception e) {
                e.printStackTrace();
            }
            reader.seek(0);
            load = reader.readLine();
            reader.close();
            toks = load.split(" ");
            long idle2 = Long.parseLong(toks[5]);
            long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3]) + Long.parseLong(toks[4])
                    + Long.parseLong(toks[6]) + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);
            return (float) (cpu2 - cpu1) / ((cpu2 + idle2) - (cpu1 + idle1));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return 0;
    }



    private static final String TAG = "DeviceUtils";

    public static int getCpuUsage() {

        try {//www.  ja v a 2  s .  c o  m
            RandomAccessFile reader = new RandomAccessFile("/proc/stat",
                    "r");
            String load = reader.readLine();

            // cpu  127262 1391 77990 17087296 5445 0 1223 0 0 0

            String[] toks = load.split(" ");

            long idle1 = Long.parseLong(toks[5]);
            long cpu1 = Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[4]) + Long.parseLong(toks[6])
                    + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

            Log.d(TAG, "line1 -- " + load);
            Log.d(TAG, "idle1 -- " + idle1);
            Log.d(TAG, "cpu1 -- " + cpu1);

            try {
                Thread.sleep(360);
            } catch (Exception e) {
            }

            reader.seek(0);
            load = reader.readLine();
            reader.close();

            toks = load.split(" ");

            long idle2 = Long.parseLong(toks[5]);
            long cpu2 = Long.parseLong(toks[2]) + Long.parseLong(toks[3])
                    + Long.parseLong(toks[4]) + Long.parseLong(toks[6])
                    + Long.parseLong(toks[7]) + Long.parseLong(toks[8]);

            Log.d(TAG, "line2 -- " + load);
            Log.d(TAG, "idle2 -- " + idle2);
            Log.d(TAG, "cpu2 -- " + cpu2);

            Log.d(TAG,
                    "usage -- "
                            + Long.toString((cpu2 - cpu1) * 100
                            / ((cpu2 + idle2) - (cpu1 + idle1))));

            long usage = cpu2 - cpu1;
            long total = (cpu2 + idle2) - (cpu1 + idle1);

            return (int) (usage * 100 / total);

        } catch (IOException ex) {
            ex.printStackTrace();
            return 0;
        }

    }

}
