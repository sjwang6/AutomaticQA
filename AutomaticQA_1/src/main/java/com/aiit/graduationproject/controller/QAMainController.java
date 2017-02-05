/**
 * Copyright 2017 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>
 * <code>QAMainController</code>
 * </p>
 *
 * @author sjwang6
 * @time 2017年1月21日 下午7:17:39
 * @since 1.0
 * @version 1.0
 */
@Controller
public class QAMainController {

	/**
	 * 问答正式入口
	 * <p>
	 * <code>QAnswerBegin</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param request
	 * @param map
	 *            返回答案
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/qaBegin", method = RequestMethod.GET)
	public String QAnswerBegin(HttpServletRequest request, Map map) {
		String question = request.getParameter("question");
		System.out.println(question);
		return null;
	}
}
