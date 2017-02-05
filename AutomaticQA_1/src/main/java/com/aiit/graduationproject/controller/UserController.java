/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.controller;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aiit.graduationproject.entity.User;
import com.aiit.graduationproject.service.UserService;
import com.aiit.graduationproject.utils.DateUtil;
import com.aiit.graduationproject.utils.MessagesUtils;
import com.aiit.graduationproject.utils.ResponseUtil;
import com.aiit.graduationproject.utils.StringUtils;

/**
 * <p>
 * <code>UserController</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月9日 下午4:46:19
 * @since 1.0
 * @version 1.0
 */
@Controller
public class UserController {

	/**
	 * 注入
	 */
	@Autowired
	private UserService userService;

	/**
	 * 日志
	 */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 登陆
	 * <p>
	 * <code>Login</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param request
	 * @param map
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "/toLogin", method = RequestMethod.POST)
	public String Login(HttpServletRequest request, Map map) {
		String Page = "";
		String userName = request.getParameter("username");
		String userPassword = request.getParameter("p");
		System.out.println(userName + "::" + userPassword);
		if (StringUtils.isNotEmpty(userName) && StringUtils.isNotEmpty(userPassword)) {
			List<User> uList = userService.findUserByNameAndPwd(userName, userPassword);
			if (uList.size() > 0) {
				request.getSession().setAttribute("User", uList.get(0));
				request.getSession().setMaxInactiveInterval(15 * 60);
				map.put("user_list", uList);
				logger.info("查询成功！：：：用户::" + userName + "::存在");
				Page = "backstage/backstage";
			} else {
				map.put("sign_in_error", MessagesUtils.getProperty(MessagesUtils.sign_in_error));
				logger.error("查询失败！：：：用户::" + userName + "::不存在");
				Page = "login";
			}
		} else {
			StringUtils.killNull(userName);
			StringUtils.killNull(userPassword);
			logger.error("页面传入的数据为空！");
			Page = "login";
		}
		logger.info("进入:::" + Page + ".jsp:::页面!");
		return Page;
	}

	/**
	 * 注销登陆信息
	 * <p>
	 * <code>loginOut</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/toLoginOut")
	public String LoginOut(HttpServletRequest request) {
		Enumeration em = request.getSession().getAttributeNames(); // 查看有session的名称
		while (em.hasMoreElements()) {
			request.getSession().removeAttribute(em.nextElement().toString()); // 移除session
		}
		request.getSession().invalidate();
		logger.info("已经退出登录，注销session,将进入登陆界面" + "login.jsp");
		return "login";
	}

	/**
	 * 注册信息
	 * <p>
	 * <code>RegisterUser</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/toRegister")
	public String RegisterUser(HttpServletRequest request) {
		String userName = request.getParameter("user");
		String userPassword = request.getParameter("passwd");
		int userSex = StringUtils.StringCastInteger(request.getParameter("radio"));
		String userBrith = request.getParameter("brith");
		String userEmail = request.getParameter("email");
		String userAddress = request.getParameter("address");
		// 根据出生日期和当前日期计算出年龄。
		int userAge = DateUtil.GetAgeFromDate(userBrith);
		User user = new User();
		user.setUserName(userName);
		user.setUserPassword(userPassword);
		user.setUserSex(userSex);
		user.setUserBrith(userBrith);
		user.setUserEmail(userEmail);
		user.setUserAddress(userAddress);
		user.setUserAge(userAge);
		// insert into DB
		return "login";
	}

	/**
	 * 根据名称判断是否用户已存在
	 * <p>
	 * <code>CheckUser</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/toCheckUser")
	public void CheckUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		List<User> ulist = userService.findUserByName(userName);
		try {
			if (ulist == null) {
				ResponseUtil.write(response, 1);
			} else {
				ResponseUtil.write(response, 0);
			}
		} catch (Exception e) {
			logger.error("ResponseUtil.write method had a error", e);
			e.printStackTrace();
		}
	}
}
