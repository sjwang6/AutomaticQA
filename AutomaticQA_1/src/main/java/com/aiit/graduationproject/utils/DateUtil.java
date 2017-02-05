/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * <p>
 * <code>DateUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 上午10:20:33
 * @since 1.0
 * @version 1.0
 */
public class DateUtil {

	/**
	 * 根据当前日期和出生日期获取年龄
	 * <p>
	 * <code>GetAgeFromDate</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param birthDay
	 *            出生日期
	 * @return userAge 年龄
	 */
	public static int GetAgeFromDate(String birthDay) {
		String date = getLocationDate();
		String year = date.substring(0, 4);
		int yearLoc = StringUtils.StringCastInteger(year);
		String[] arr = birthDay.split("/");
		// System.out.println(yearLoc + "::" + arr[2]);
		int brithYear = StringUtils.StringCastInteger(arr[2]);
		int userAge = yearLoc - brithYear + 1;
		return userAge;
	}

	/**
	 * 获取当前时间 格式化日期格式为 年-月-日 时：分：秒 结果：2016-12-27 10:40:46
	 * <p>
	 * <code>getLocationDate</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @return
	 */
	public static String getLocationDate() {
		Date date = new Date();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		return sdf.format(date);
	}

	/**
	 * 将 String类型的日期转化为年、月、日
	 * <p>
	 * <code>DateToInt</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param dateString
	 * @return int[] 数组
	 */
	public static String[] DateToInt(String dateString) {
		String[] time = dateString.split("-");
		String[] dateInt = new String[time.length];
		dateInt[0] = concatZore(Integer.parseInt(time[0]));
		dateInt[1] = concatZore(Integer.parseInt(time[1]));
		dateInt[2] = concatZore(Integer.parseInt(time[2]));
		return dateInt;
	}

	/**
	 * 根据年份和月份判断该月是多少天，即判断平年和闰年
	 * <p>
	 * <code>judgeDayByMonth</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param year
	 * @param month
	 * @return
	 */
	public static int judgeDayByMonth(int year, int month) {
		int day1 = 0;
		if (month == 2) {
			if (year % 4 == 0 || (year % 100 == 0 && year % 400 == 0)) {
				// 闰年 29天
				day1 = 29;
			} else {
				// 平年28天
				day1 = 28;
			}
		}
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
			// 31天
			day1 = 31;
		}
		if (month == 4 || month == 6 || month == 9 || month == 11) {
			// 30天
			day1 = 30;
		}
		return day1;
	}

	/**
	 * 从今天开始的时间到7天后的时间====入口
	 * <p>
	 * <code>enter</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param date
	 */
	public static String[] enter(Date date, int NUM) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String times = format.format(date);
		String[] time = times.split("-");
		int year = Integer.parseInt(time[0]);
		int month = Integer.parseInt(time[1]);
		int day = Integer.parseInt(time[2]);
		String[] date1 = setInit(year, month, day, NUM);
		return date1;
	}

	/**
	 * 从今天开始的时间到7天前的时间====入口
	 * <p>
	 * <code>pre_enter</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param date
	 */
	public static String[] pre_enter(Date date, int NUM) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String times = format.format(date);
		String[] time = times.split("-");
		int year = Integer.parseInt(time[0]);
		int month = Integer.parseInt(time[1]);
		int day = Integer.parseInt(time[2]);
		String[] date1 = setPre(year, month, day, NUM);
		return date1;
	}

	/**
	 * 当每个月的临界值到达时的初始化(带今天的日期的)=== 日期++
	 * <p>
	 * <code>setInit</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param year
	 *            当前日期：年
	 * @param month
	 *            当前日期：月
	 * @param day
	 *            当前日期：日
	 * @param continueNUM
	 *            循环的天数
	 * @param day1
	 *            每个月的 临界值
	 */
	public static String[] setInit(int year, int month, int day, int continueNUM) {
		String[] dateSZ = new String[continueNUM];
		int day1 = 0; // 临界值
		dateSZ[0] = year + "-" + concatZore(month) + "-" + concatZore(day); // 今天日期（若想不带今天的日期这去除）
		for (int i = 0; i < continueNUM - 1; i++) {
			day1 = judgeDayByMonth(year, month);
			// 循环之后大于等于临界值时跳出
			if (day >= day1) {
				month++;
				day = 0;
				if (month > 12) { // 12是月份的临界值
					year++;
					day = 0;
					month = 1;
				}
			}
			day++;
			dateSZ[i + 1] = year + "-" + concatZore(month) + "-" + concatZore(day);
		}
		return dateSZ;
	}

	/**
	 * 当每个月的临界值到达时的初始化(带今天的日期的) ==== 日期--
	 * <p>
	 * <code>setPre</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param year
	 *            当前日期：年
	 * @param month
	 *            当前日期：月
	 * @param day
	 *            当前日期：日
	 * @param continueNUM
	 *            循环的天数
	 * @param day1
	 *            每个月的 临界值
	 */
	public static String[] setPre(int year, int month, int day, int continueNUM) {
		String[] dateSZ = new String[continueNUM];
		// dateSZ[0] = year + "-" + concatZore(month) + "-" + concatZore(day);
		// // 今天日期（若想不带今天的日期这去除）
		for (int i = 0; i < continueNUM; i++) {
			// 循环之后小于等于临界值时跳出
			if (day <= 1) {
				month--;
				day = judgeDayByMonth(year, month) + 1;
				if (month < 1) { // 1是月份的临界值
					year--;
					month = 12;
					day = judgeDayByMonth(year, month) + 1;
				}
			}
			day--;
			dateSZ[i] = year + "-" + concatZore(month) + "-" + concatZore(day);
		}
		return dateSZ;
	}

	/**
	 * 如果日期是个位数就补全，为零 。如：2016-2-3 ===> 2016-02-03
	 * <p>
	 * <code>concatZore</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param digit
	 * @return
	 */
	public static String concatZore(int digit) {
		String Digit = "";
		if (digit < 10) {
			Digit = "0" + String.valueOf(digit);
		} else {
			Digit = String.valueOf(digit);
		}
		return Digit;
	}

	/**
	 * 测试
	 */
	public static void main(String[] args) {
		// String[] ss = pre_enter(new Date(), 2);
		// for (int i = 0; i < ss.length; i++) {
		// System.out.println(ss[i]);
		// }
		// String[] ss = enter(new Date(), 2);
		// for (int i = 0; i < ss.length; i++) {
		// System.out.println(ss[i]);
		// }
		int a = GetAgeFromDate("4/4/1994");
		System.out.println("年龄是：：：：" + a);
	}
}
