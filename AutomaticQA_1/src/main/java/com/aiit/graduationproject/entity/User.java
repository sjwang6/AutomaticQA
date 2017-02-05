/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.entity;

/**
 * 用户User的实体类
 * <p>
 * <code>User</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月9日 下午4:46:35
 * @since 1.0
 * @version 1.0
 */
public class User {

	/**
	 * 用户编号
	 */
	private int userId;
	
	/**
	 * 用户名称
	 */
	private String userName;
	
	/**
	 * 用户性别 1男0女
	 */
	private int userSex;
	
	/**
	 * 出生日期
	 */
	private String userBrith;
	/**
	 * 用户年龄
	 */
	private int userAge;
	
	/**
	 * 用户密码
	 */
	private String userPassword;
	
	/**
	 * 用户邮件
	 */
	private String userEmail;
	
	/**
	 * 用户地址
	 */
	private String userAddress;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userSex
	 */
	public int getUserSex() {
		return userSex;
	}

	/**
	 * @param userSex the userSex to set
	 */
	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	/**
	 * @return the userBrith
	 */
	public String getUserBrith() {
		return userBrith;
	}

	/**
	 * @param userBrith the userBrith to set
	 */
	public void setUserBrith(String userBrith) {
		this.userBrith = userBrith;
	}

	/**
	 * @return the userAge
	 */
	public int getUserAge() {
		return userAge;
	}

	/**
	 * @param userAge the userAge to set
	 */
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}

	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	/**
	 * 无参数的构造函数
	 */
	public User() {
		super();
	}

	/**
	 * 有参数的构造函数
	 * @param userId
	 * @param userName
	 * @param userSex
	 * @param userBrith
	 * @param userAge
	 * @param userPassword
	 * @param userEmail
	 * @param userAddress
	 */
	public User(int userId, String userName, int userSex,String userBrith, int userAge, String userPassword, String userEmail,
			String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userSex = userSex;
		this.userBrith = userBrith;
		this.userAge = userAge;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userAddress = userAddress;
	}

	/**   
	 * @see java.lang.Object#toString()    
	 */  
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userSex=" + userSex + ", userBrith=" + userBrith+ ", userAge=" + userAge
				+ ", userPassword=" + userPassword + ", userEmail=" + userEmail + ", userAddress=" + userAddress + "]";
	}
}
