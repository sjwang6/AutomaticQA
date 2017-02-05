/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.aiit.graduationproject.entity.User;

/**
 * 用户相关接口实现
 * <p>
 * <code>UserDao</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月9日 下午4:46:35
 * @since 1.0
 * @version 1.0
 */
public interface UserDao {

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
	public List<User> findUserByNameAndPwd(@Param("userName") String userName,
			@Param("userPassword") String userPassword);

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
	public List<User> findUserByName(@Param("userName") String userName);

}
