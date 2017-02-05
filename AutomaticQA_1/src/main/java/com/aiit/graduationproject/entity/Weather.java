/**
 * Copyright 2016 Iflytek, Inc. All rights reserved.
 */
package com.aiit.graduationproject.entity;

/**
 * 天气Weather实体类
 * <p>
 * <code>Weather</code>
 * </p>
 *
 * @author sjwang6
 * @time 2016年12月26日 上午11:16:10
 * @since 1.0
 * @version 1.0
 */
public class Weather {

	/**
	 * 天气编号
	 */
	private int weatherId;

	/**
	 * 时间
	 */
	private String weatherDate;

	/**
	 * 风速
	 */
	private String weatherWind;

	/**
	 * 天气现象
	 */
	private String weatherPhenomenon;

	/**
	 * 最高温度
	 */
	private String weatherBigTemperature;

	/**
	 * 最低温度
	 */
	private String weatherSmallTemperature;

	/**
	 * 风向
	 */
	private String weatherWindRun;

	/**
	 * 地区外键
	 */
	private int fkAreaId;

	/**
	 * @return the weatherId
	 */
	public int getWeatherId() {
		return weatherId;
	}

	/**
	 * @param weatherId
	 *            the weatherId to set
	 */
	public void setWeatherId(int weatherId) {
		this.weatherId = weatherId;
	}

	/**
	 * @return the weatherDate
	 */
	public String getWeatherDate() {
		return weatherDate;
	}

	/**
	 * @param weatherDate
	 *            the weatherDate to set
	 */
	public void setWeatherDate(String weatherDate) {
		this.weatherDate = weatherDate;
	}

	/**
	 * @return the weatherWind
	 */
	public String getWeatherWind() {
		return weatherWind;
	}

	/**
	 * @param weatherWind
	 *            the weatherWind to set
	 */
	public void setWeatherWind(String weatherWind) {
		this.weatherWind = weatherWind;
	}

	/**
	 * @return the weatherPhenomenon
	 */
	public String getWeatherPhenomenon() {
		return weatherPhenomenon;
	}

	/**
	 * @param weatherPhenomenon
	 *            the weatherPhenomenon to set
	 */
	public void setWeatherPhenomenon(String weatherPhenomenon) {
		this.weatherPhenomenon = weatherPhenomenon;
	}

	/**
	 * @return the weatherBigTemperature
	 */
	public String getWeatherBigTemperature() {
		return weatherBigTemperature;
	}

	/**
	 * @param weatherBigTemperature
	 *            the weatherBigTemperature to set
	 */
	public void setWeatherBigTemperature(String weatherBigTemperature) {
		this.weatherBigTemperature = weatherBigTemperature;
	}

	/**
	 * @return the weatherSmallTemperature
	 */
	public String getWeatherSmallTemperature() {
		return weatherSmallTemperature;
	}

	/**
	 * @param weatherSmallTemperature
	 *            the weatherSmallTemperature to set
	 */
	public void setWeatherSmallTemperature(String weatherSmallTemperature) {
		this.weatherSmallTemperature = weatherSmallTemperature;
	}

	/**
	 * @return the weatherWindRun
	 */
	public String getWeatherWindRun() {
		return weatherWindRun;
	}

	/**
	 * @param weatherWindRun
	 *            the weatherWindRun to set
	 */
	public void setWeatherWindRun(String weatherWindRun) {
		this.weatherWindRun = weatherWindRun;
	}

	/**
	 * @return the fkAreaId
	 */
	public int getFkAreaId() {
		return fkAreaId;
	}

	/**
	 * @param fkAreaId
	 *            the fkAreaId to set
	 */
	public void setFkAreaId(int fkAreaId) {
		this.fkAreaId = fkAreaId;
	}

	/**
	 * 无参数的构造参数
	 */
	public Weather() {
		super();
	}

	/**
	 * 有参数的构造参数
	 * 
	 * @param weatherId
	 * @param weatherDate
	 * @param weatherWind
	 * @param weatherPhenomenon
	 * @param weatherBigTemperature
	 * @param weatherSmallTemperature
	 * @param weatherWindRun
	 * @param fkAreaId
	 */
	public Weather(int weatherId, String weatherDate, String weatherWind, String weatherPhenomenon,
			String weatherBigTemperature, String weatherSmallTemperature, String weatherWindRun, int fkAreaId) {
		super();
		this.weatherId = weatherId;
		this.weatherDate = weatherDate;
		this.weatherWind = weatherWind;
		this.weatherPhenomenon = weatherPhenomenon;
		this.weatherBigTemperature = weatherBigTemperature;
		this.weatherSmallTemperature = weatherSmallTemperature;
		this.weatherWindRun = weatherWindRun;
		this.fkAreaId = fkAreaId;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Weather [weatherId=" + weatherId + ", weatherDate=" + weatherDate + ", weatherWind=" + weatherWind
				+ ", weatherPhenomenon=" + weatherPhenomenon + ", weatherBigTemperature=" + weatherBigTemperature
				+ ", weatherSmallTemperature=" + weatherSmallTemperature + ", weatherWindRun=" + weatherWindRun
				+ ", fkAreaId=" + fkAreaId + "]";
	}

}
