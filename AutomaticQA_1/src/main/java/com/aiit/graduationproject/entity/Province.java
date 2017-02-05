/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.entity;

/**
 * 省份实体类
 * <p>
 * <code>Province</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 下午1:47:44
 * @since 1.0
 * @version 1.0
 */
public class Province {

	/**
	 * 省编号
	 */
	private int provinceId;

	/**
	 * 省url
	 */
	private String provinceUrl;

	/**
	 * 省名称
	 */
	private String provinceName;

	/**
	 * @return the provinceId
	 */
	public int getProvinceId() {
		return provinceId;
	}

	/**
	 * @param provinceId
	 *            the provinceId to set
	 */
	public void setProvinceId(int provinceId) {
		this.provinceId = provinceId;
	}

	/**
	 * @return the provinceUrl
	 */
	public String getProvinceUrl() {
		return provinceUrl;
	}

	/**
	 * @param provinceUrl
	 *            the provinceUrl to set
	 */
	public void setProvinceUrl(String provinceUrl) {
		this.provinceUrl = provinceUrl;
	}

	/**
	 * @return the provinceName
	 */
	public String getProvinceName() {
		return provinceName;
	}

	/**
	 * @param provinceName
	 *            the provinceName to set
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	/**
	 * 无参数的构造函数
	 */
	public Province() {
		super();
	}

	/**
	 * 有参数的构造函数
	 * 
	 * @param provinceId
	 * @param provinceUrl
	 * @param provinceName
	 */
	public Province(int provinceId, String provinceUrl, String provinceName) {
		super();
		this.provinceId = provinceId;
		this.provinceUrl = provinceUrl;
		this.provinceName = provinceName;
	}
}
