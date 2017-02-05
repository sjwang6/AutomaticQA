/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.utils;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 仅跳转到界面
 * <p>
 * <code>JumpToJspViewsUtils</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月23日 下午2:43:16
 * @since 1.0
 * @version 1.0
 */
@Controller
public class JumpToJspViewsUtils {

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(JumpToJspViewsUtils.class);

	@RequestMapping(value = "/login")
	public String JumpToLoginJspViews() {
		logger.info("进入登陆界面");
		return "login";
	}

	@RequestMapping(value = "/toBackstage")
	public String JumpToBackstageJspViews(Map<String, String> map) {
		logger.info("进入后台数据界面");
		return "backstage/backstage";
	}

	// @RequestMapping(value ="/weather")
	// public String JumpToDatalistJspViews(Map<String, String> map){
	// logger.info("进入后台数据界面");
	// return "backstage/weather";
	// }
}
