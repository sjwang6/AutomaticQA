/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.service;

import java.util.List;

import com.aiit.graduationproject.entity.User;

/**
 * <p>
 * <code>UserService</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月9日 下午4:47:39
 * @since 1.0
 * @version 1.0
 */
public interface UserService {

	/**
	 * 根据用户名和密码判断是否存在
	 * <p>
	 * <code>findUserByNameAndPwd</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param userName
	 * @param userPassword
	 * @return
	 */
	public List<User> findUserByNameAndPwd(String userName, String userPassword);

	/**
	 * 根据用户名判断是否存在
	 * <p>
	 * <code>findUserByName</code>
	 * </p>
	 * 
	 * @author sjwang6
	 * @param userName
	 * @return
	 */
	public List<User> findUserByName(String userName);
}
