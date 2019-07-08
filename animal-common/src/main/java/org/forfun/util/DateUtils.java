package org.forfun.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DateUtils {

    public static final String DATE_JFP_STR = "yyyyMM";
    public static final String DATE_FULL_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_SMALL_STR = "yyyy-MM-dd";
    public static final String DATE_KEY_STR = "yyMMddHHmmss";
    public static final String DATE_KEY_FULL_STR = "yyyyMMddHHmmss";
    public static final String DATE_KEY_HOUR_STR = "yyyy-MM-dd HH";

    /**
     * 使用默认格式转时间
     *
     * @param strDate
     * @return
     */
    public static Date parse(String strDate) {
        return parse(strDate, DATE_FULL_STR);
    }

    /**
     * 把字符串时间转成指定格式
     *
     * @param strDate
     * @param pattern
     * @return
     */
    public static Date parse(String strDate, String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        try {
            return df.parse(strDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getTaday() {
        return getTaday(DATE_FULL_STR);
    }

    /**
     * 获取当前指定格式时间
     *
     * @param pattern
     * @return
     */
    public static String getTaday(String pattern) {
        SimpleDateFormat df = new SimpleDateFormat(pattern);
        return df.format(new Date());
    }

    /**
     * 获取昨天时间字符串
     *
     * @return
     */
    public static String getYesterday() {

        return getYesterday(DATE_FULL_STR);
    }

    /**
     * 获取昨天时间字符串
     *
     * @return
     */
    public static String getYesterday(String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return new SimpleDateFormat(pattern).format(cal.getTime());
    }

    /**
     * 获取指定天数之后
     *
     * @param dateformat
     * @param day
     * @return
     */
    public static String getAfterDate(String dateformat, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) + day);
        DateFormat df = new SimpleDateFormat(dateformat);
        String str = df.format(cal.getTime());
        return str;
    }

    /**
     * 获取指定天数之前的时间
     *
     * @param day
     * @return
     */
    public static Date getBeforeDate(int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, cal.get(Calendar.DATE) - day);
        return cal.getTime();
    }

    /**
     * 根据type 分别获取 年 月 日 时 分 秒
     *
     * @param type
     * @return
     */
    public static Integer getDateByType(int type) {
        Calendar calendar = Calendar.getInstance();
        int result = calendar.get(type);
        if (type == Calendar.MONTH) result++;
        return result;
    }

    public static Date startDate(Date date) {
        return setCalendarFields(date, 0, 0, 0).getTime();
    }

    public static Date endDate(Date date) {
        return setCalendarFields(date, 23, 59, 59).getTime();
    }

    private static Calendar setCalendarFields(Date date, int hour, int minute, int second) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        return calendar;
    }

    public static String getCurrentHour() {
        return getCurrentHour(DATE_FULL_STR);
    }

    public static String getCurrentHour(String dateformat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
        return sdf.format(new Date());
    }

    public static String getCurrentHourDateStr(String dateformat) {
        return new SimpleDateFormat(dateformat).format(new Date());
    }

    public static String getPreHourDate(String dateformat) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 1);
        SimpleDateFormat df = new SimpleDateFormat(dateformat);
        return df.format(calendar.getTime());
    }

    public static String getFormattedDate(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 获取固定间隔时刻集合
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param interval  时间间隔(单位：分钟)
     * @return
     */
    public static List<Date> getIntervalTimeList(Date startDate, Date endDate, int interval) {
        List<Date> list = new ArrayList<>();
        while (startDate.getTime() <= endDate.getTime()) {
            list.add(startDate);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE, interval);
            if (calendar.getTime().getTime() > endDate.getTime()) {
                if (!startDate.equals(endDate)) {
                    list.add(endDate);
                }
                startDate = calendar.getTime();
            } else {
                startDate = calendar.getTime();
            }

        }
        return list;
    }

    /**
     * 获取固定间隔时刻集合
     *
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param interval  时间间隔(单位：分钟)
     * @return
     */
    public static List<String> getIntervalTimeList(Date startDate, Date endDate, String pattern, int interval) {
        List<String> list = new ArrayList<>();
        while (startDate.getTime() <= endDate.getTime()) {
            list.add(getFormattedDate(startDate, pattern));
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.MINUTE, interval);
            if (calendar.getTime().getTime() > endDate.getTime()) {
                if (!startDate.equals(endDate)) {
                    list.add(getFormattedDate(endDate, pattern));
                }
                startDate = calendar.getTime();
            } else {
                startDate = calendar.getTime();
            }

        }
        return list;
    }
}
