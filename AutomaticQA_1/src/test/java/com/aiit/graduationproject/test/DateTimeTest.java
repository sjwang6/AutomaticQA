/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.aiit.graduationproject.utils.DateUtil;

/**
 * <p>
 * <code>DateTimeTest</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 上午10:36:01
 * @since 1.0
 * @version 1.0
 */
public class DateTimeTest {

	@Test
	public void test() {
		System.out.println(11);
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(date));
		System.out.println("===============================");
		String[] dd = DateUtil.enter(date,7);
		for (int i = 0; i < dd.length; i++) {
			System.out.println(dd[i]);
		}
	}
}
