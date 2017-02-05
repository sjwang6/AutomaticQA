/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiit.graduationproject.dao.UserDao;
import com.aiit.graduationproject.entity.User;
import com.aiit.graduationproject.service.UserService;

/**
 * <p>
 * <code>UserServiceImpl</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月23日 下午3:24:12
 * @since 1.0
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

	/**
	 * 注入
	 */
	@Autowired
	private UserDao userDao;

	/**
	 * @see com.aiit.graduationproject.service.UserService#findUserByNameAndPwd(java.lang.String,
	 *      java.lang.String)
	 */
	public List<User> findUserByNameAndPwd(String userName, String userPassword) {

		return userDao.findUserByNameAndPwd(userName, userPassword);
	}

	/**
	 * @see com.aiit.graduationproject.service.UserService#findUserByName(java.lang.String)
	 */
	public List<User> findUserByName(String userName) {

		return userDao.findUserByName(userName);
	}

}
