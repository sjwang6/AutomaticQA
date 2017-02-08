/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

/**
 * <p>
 * <code>PageUtil</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年2月6日 下午5:10:12
 * @since 1.0
 * @version 1.0
 */
public class PageUtil {

	/**
	 * 根据pageNum和pageSize进行归类
	 * <p>
	 * <code>pageViews</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param string
	 *            页面接收的值
	 * @param Num
	 *            转化后的值
	 * @return
	 */
	public static int[] pageViews(String string, int Num) {
		int[] pageview = new int[3];
		int pageNum, pageSize, endNum;
		if (StringUtils.isEmpty(string)) {
			pageNum = 1;
			pageSize = 10;
		} else {
			pageNum = Num;
			pageSize = 10;
		}
		endNum = (pageNum - 1) * pageSize;
		pageview[0] = endNum;
		pageview[1] = pageSize;
		pageview[2] = pageNum;
		return pageview;
	}
}
