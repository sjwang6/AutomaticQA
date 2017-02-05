/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.test;

import org.junit.Test;

import com.aiit.graduationproject.utils.MessagesUtils;

/**
 * <p>
 * <code>MessagesTest</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月9日 下午4:34:34
 * @since 1.0
 * @version 1.0
 */
public class MessagesTest {

	@Test
	public void test() {
		System.out.println(11);
		String password_error = MessagesUtils.getProperty(MessagesUtils.password_error);
		String logs_path = MessagesUtils.getProperty(MessagesUtils.logs_path);
		String sserror = MessagesUtils.getProperty("USER");
		System.out.println(sserror);
		System.out.println(password_error);
		System.out.println(logs_path);
	}
}
