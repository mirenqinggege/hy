package com.m3.fzo.hy.common.util.date;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateFormatUtils;
/**
 * 时间工具类
 * 
 * @author ruoyi
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils
{
    public static String YYYY = "yyyy";

    public static String YYYY_MM = "yyyy-MM";

    public static String YYYY_MM_DD = "yyyy-MM-dd";

    public static String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

    public static String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    
    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM", 
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 获取当前Date型日期
     * 
     * @return Date() 当前日期
     */
    public static Date getNowDate()
    {
        return new Date();
    }

    /**
     * 获取当前日期, 默认格式为yyyy-MM-dd
     * 
     * @return String
     */
    public static String getDate()
    {
        return dateTimeNow(YYYY_MM_DD);
    }

    public static final String getTime()
    {
        return dateTimeNow(YYYY_MM_DD_HH_MM_SS);
    }

    public static final String dateTimeNow()
    {
        return dateTimeNow(YYYYMMDDHHMMSS);
    }

    public static final String dateTimeNow(final String format)
    {
        return parseDateToStr(format, new Date());
    }

    public static final String dateTime(final Date date)
    {
        return parseDateToStr(YYYY_MM_DD, date);
    }

    public static final String parseDateToStr(final String format, final Date date)
    {
        return new SimpleDateFormat(format).format(date);
    }

    public static final Date dateTime(final String format, final String ts)
    {
        try
        {
            return new SimpleDateFormat(format).parse(ts);
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
    }

    /**
     * 日期路径 即年/月/日 如2018/08/08
     */
    public static final String datePath()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyy/MM/dd");
    }

    /**
     * 日期路径 即年/月/日 如20180808
     */
    public static final String dateTime()
    {
        Date now = new Date();
        return DateFormatUtils.format(now, "yyyyMMdd");
    }

    /**
     * 日期型字符串转化为日期 格式
     */
    public static Date parseDate(Object str)
    {
        if (str == null)
        {
            return null;
        }
        try
        {
            return parseDate(str.toString(), parsePatterns);
        }
        catch (ParseException e)
        {
            return null;
        }
    }
    
    /**
     * 获取服务器启动时间
     */
    public static Date getServerStartDate()
    {
        long time = ManagementFactory.getRuntimeMXBean().getStartTime();
        return new Date(time);
    }

    /**
     * 计算两个时间差
     */
    public static String getDatePoor(Date endDate, Date nowDate)
    {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        // long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        // long sec = diff % nd % nh % nm / ns;
        return day + "天" + hour + "小时" + min + "分钟";
    }

    /**
     * 得到当前月第一天
     * @return
     */
    public static Date getCurrentMonthFristDay(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,1);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,1);
        c.set(Calendar.SECOND,1);
        return c.getTime();
    }

    /**
     * 得到当月最后一天
     */
    public static Date getCurrentMonthLastDay(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DATE,1);
        c.roll(Calendar.DATE,-1);
        return c.getTime();
    }

    /**
     * 得到指定月的第一天
     */
    public static Date getSpecifiedMonthFristDay(int year,int month){
        Calendar c = Calendar.getInstance();
        c.set(year,month-1,1);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,1);
        c.set(Calendar.SECOND,1);
        return c.getTime();
    }

    /**
     * 得到指定月的最后一天
     */
    public static Date getSpecifiedMonthLastDay(int year,int month){
        Calendar c = Calendar.getInstance();
        c.set(year,month-1,1);
        c.roll(Calendar.DATE,-1);
        c.set(Calendar.HOUR_OF_DAY,0);
        c.set(Calendar.MINUTE,1);
        c.set(Calendar.SECOND,1);
        return c.getTime();
    }

    /**
     *  正值为之后负值为之前
     *  0为不更改
     * @param year 年
     * @param month 月
     * @param day 日
     * @param hour 时
     * @param min 分
     * @param second 秒
     * @return
     */
    public static Date getSpecifiedDate(int year,int month,int day,int hour,int min,int second){
        Calendar c = Calendar.getInstance();
        if(year != 0) c.set(Calendar.YEAR,c.get(Calendar.YEAR) + year);
        if(month != 0) c.set(Calendar.MONTH,c.get(Calendar.MONTH) + month);
        if(day != 0) c.set(Calendar.DAY_OF_MONTH,c.get(Calendar.DAY_OF_MONTH) + day);
        if(hour != 0) c.set(Calendar.HOUR_OF_DAY,c.get(Calendar.HOUR_OF_DAY) + hour);
        if(min != 0) c.set(Calendar.MINUTE,c.get(Calendar.MINUTE) + min);
        if(second != 0) c.set(Calendar.SECOND,c.get(Calendar.SECOND) + second);

        return c.getTime();
    }
    /*public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.err.println(getSpecifiedDate(0,0,0,0,-10,0));
    }*/
}
