package com.itcrazy.algorithm.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: dengxin.chen
 * @version: $ TimeUtils.java,v0.1 2025-03-10 19:57 dengxin.chen Exp $
 * @description:
 */
public class TimeUtils {

    /**
     * 最大年数值
     */
    public static final int MAX_YEAR_VALUE = 9999;

    /**
     * 最大月数值
     */
    public static final int MAX_MONTH_VALUE = 12;

    /**
     * 最大天数值
     */
    public static final int MAX_DAY_VALUE = 31;

    /**
     * 二月最大天数值
     */
    public static final int FEB_MAX_DAY_VALUE = 29;

    /**
     * 闰年二月天数
     */
    public static final int LEAP_YEAR_FEB_DAY_VALUE = 29;

    /**
     * 固定月与天数映射
     */
    public static Map<Integer, Integer> FIXED_MONTH_MAP_DAY = new HashMap<Integer, Integer>() {{
        // 大月
        put(1, 31);
        put(3, 31);
        put(5, 31);
        put(7, 31);
        put(8, 31);
        put(10, 31);
        put(12, 31);
        // 小月
        put(4, 30);
        put(6, 30);
        put(9, 30);
        put(11, 30);
    }};

    /**
     * 获取天在一年中的具体天数
     * by dengxin.chen
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    public static int dayOfYear(int year, int month, int day) {
        boolean checkResult = checkDate(year, month, day);
        // 校验未通过，直接返回-1
        if (!checkResult) {
            return -1;
        }
        // 计算总天数
        return calTotalDays(year, month, day);
    }

    /**
     * 校验日期格式
     * by dengxin.chen
     *
     * @param year
     * @param month
     * @param day
     * @return true-校验通过 false-校验不通过
     */
    private static boolean checkDate(int year, int month, int day) {
        // 年校验
        if (year <= 0 || year > MAX_YEAR_VALUE) {
            return false;
        }
        // 月份校验
        if (month <= 0 || month > MAX_MONTH_VALUE) {
            return false;
        }
        // 天数校验
        if (day <= 0 || day > MAX_DAY_VALUE) {
            return false;
        }
        // 二月份特殊校验
        if (month == 2 && day > FEB_MAX_DAY_VALUE) {
            return false;
        }
        return true;
    }

    /**
     * 计算总天数
     * by dengxin.chen
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private static int calTotalDays(int year, int month, int day) {
        // 1月份直接返回即可
        if (month == 1) {
            return day;
        }
        // 判断是否为闰年
        boolean leapYear = isLeapYear(year);
        // 总天数先赋值为最后月天数
        int totalDays = day;
        for (int monthIndex = 1; monthIndex <= month - 1; monthIndex++) {
            Integer monthTotalDay = FIXED_MONTH_MAP_DAY.get(monthIndex);
            if (Objects.isNull(monthTotalDay)) {
                if (leapYear) {
                    totalDays += LEAP_YEAR_FEB_DAY_VALUE;
                } else {
                    totalDays += LEAP_YEAR_FEB_DAY_VALUE - 1;
                }
            } else {
                totalDays += monthTotalDay;
            }
        }
        return totalDays;
    }

    /**
     * 判断是否为闰年
     * by dengxin.chen
     *
     * @param year
     * @return true-是闰年 false-不是闰年
     */
    private static boolean isLeapYear(int year) {
        /**
         *闰年条件:
         * 1.能被4整除且不能被100整除
         * 2.能被400整除
         * 任意满足以上任意条件即可
         */
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void main(String[] args) {
        System.out.println(dayOfYear(2016, 3, 1));
    }
}
