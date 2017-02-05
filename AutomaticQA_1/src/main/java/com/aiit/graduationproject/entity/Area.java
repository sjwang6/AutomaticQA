/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.entity;

/**
 * 地区实体类
 * <p>
 * <code>Area</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月27日 下午1:43:51
 * @since 1.0
 * @version 1.0
 */
public class Area {

	/**
	 * 地区编号
	 */
	private int areaId;

	/**
	 * 地区url
	 */
	private String areaUrl;

	/**
	 * 地区名称
	 */
	private String areaName;

	/**
	 * @return the areaId
	 */
	public int getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId
	 *            the areaId to set
	 */
	public void setAreaId(int areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return the areaUrl
	 */
	public String getAreaUrl() {
		return areaUrl;
	}

	/**
	 * @param areaUrl
	 *            the areaUrl to set
	 */
	public void setAreaUrl(String areaUrl) {
		this.areaUrl = areaUrl;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName
	 *            the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * 无参数构造函数
	 */
	public Area() {
		super();
	}

	/**
	 * 有参数的构造函数
	 * 
	 * @param areaId
	 * @param areaUrl
	 * @param areaName
	 * @param fkProvinceId
	 */
	public Area(int areaId, String areaUrl, String areaName) {
		super();
		this.areaId = areaId;
		this.areaUrl = areaUrl;
		this.areaName = areaName;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Area [areaId=" + areaId + ", areaUrl=" + areaUrl + ", areaName=" + areaName + "]";
	}
}
