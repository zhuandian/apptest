package com.zhuandian.apptest.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtils {

    public static String getTimeStrNow() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateNowStr = sdf.format(new Date());
//        System.out.println("格式化后的日期：" + dateNowStr);
        return dateNowStr;
    }


    public static String getTomorrowDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 1);//-1.昨天时间 0.当前时间 1.明天时间 *以此类推
        String time = sdf.format(c.getTime());
        return time;
    }

    public static String getYestodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, -1);//-1.昨天时间 0.当前时间 1.明天时间 *以此类推
        String time = sdf.format(c.getTime());
        return time;
    }

    /**
     * 获取今日周几
     *
     * @return
     */
    public static int getWeek() {
        int week = 0;
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = 7;
        } else if (weekday == 2) {
            week = 1;
        } else if (weekday == 3) {
            week = 2;
        } else if (weekday == 4) {
            week = 3;
        } else if (weekday == 5) {
            week = 4;
        } else if (weekday == 6) {
            week = 5;
        } else if (weekday == 7) {
            week = 6;
        }
        return week;
    }


    /**
     * 获取明天周几
     *
     * @return
     */
    public static String getWeekTomorrow() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 1);//+1 明天

        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0)
            w = 0;
        return weekDays[w];
    }


    /**
     * 获取当前是本学期的第几周
     *
     * @return
     */
    public static int getTodyWeekIndex() {
        return getDiffDays("20210301") / 7 + 1;
    }


    /**
     * 获取明天是本学期的第几周
     *
     * @return TODO 课表推送时，周日显示的第几周不对
     */
    public static int getTomorrowWeekIndex() {
        if (getWeekTomorrow().equals("星期一")) {
            return getDiffDays("20210301") / 7 + 2;
        } else {
            return getDiffDays("20210301") / 7 + 1;
        }

    }

    /**
     * 获取两个日期直接的相差间隔
     *
     * @param startTime
     * @return
     */
    private static int getDiffDays(String startTime) {
        String today = String.format("%1$04d", Calendar.getInstance().get(Calendar.YEAR)) +
                String.format("%1$02d", Calendar.getInstance().get(Calendar.MONTH) + 1) +
                String.format("%1$02d", Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        Date date1, date2;
        try {
            date1 = simpleDateFormat.parse(startTime);
            date2 = simpleDateFormat.parse(today);
            return getGapCount(date1, date2);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 获取两个日期之间的间隔天数
     */
    private static int getGapCount(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24));
    }
}
